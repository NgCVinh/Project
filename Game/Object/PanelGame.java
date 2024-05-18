package Game.Object;

import Game.Rocket.BulletRocket;
import Game.Rocket.Rocket;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PanelGame extends JComponent {

    public Graphics2D g2;
    public BufferedImage image;
    private int width;
    private int height;
    private Thread thread;
    private boolean start = true;
    private Key key;
    private int shotTime;

    private final int FPS = 60;
    private final int TARGET_TIME = 1000000000 / FPS;
    private Sound sound;
    private Player player;
    private List<Bullet> bullets;
    private List<Rocket> rockets;
    private List<BulletRocket> bulletRockets;
    private int score = 0;
    private int superBullet=100;
    private final int shoot=10;

    public void start() {
        width = getWidth();
        height = getHeight();
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        g2 = image.createGraphics();
        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (start) {
                    long startTime = System.nanoTime();
                    drawBackground();
                    drawGame();
                    checkPlayer();
                    render();
                    long time = System.nanoTime() - startTime;
                    if (time < TARGET_TIME) {
                        long sleep = (TARGET_TIME - time) / 1000000;
                        sleep(sleep);
                    }
                }
            }
        });
        initObjectGame();
        initKeyboard();
        initBullets();
        thread.start();
    }
    private void addRocket() {
        Random ran = new Random();
        int locationY = ran.nextInt(height - 50) + 25;
        Rocket rocket = new Rocket();
        rocket.changeLocation(0, locationY);
        rocket.changeAngle(0);
        rockets.add(rocket);
        for(int i=1;i<=shoot;i++) {
            bulletRockets.add(0, new BulletRocket(0, locationY, rocket.getAngle(), 5, shoot-i+2, new ImageIcon("C:\\Users\\ASUS\\IdeaProjects\\test\\src\\Game\\laser bullet.png").getImage()));
        }
        int locationY2 = ran.nextInt(height - 50) + 25;
        Rocket rocket2 = new Rocket();
        rocket2.changeLocation(width, locationY2);
        rocket2.changeAngle(180);
        rockets.add(rocket2);
        for(int i=1;i<=shoot;i++) {
            bulletRockets.add(0, new BulletRocket(width-50,locationY2, rocket2.getAngle(), 5,shoot-i+2, new ImageIcon("C:\\Users\\ASUS\\IdeaProjects\\test\\src\\Game\\laser bullet 2.png").getImage()));
        }
    }
    private void initObjectGame() {
        sound = new Sound();
        player = new Player();
        player.changeLocation(150, 150);
        rockets = new ArrayList<>();
        bulletRockets=new ArrayList<>();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (start) {
                    addRocket();
                    sleep(3000);
                }
            }
        }).start();
    }
    private void resetGame() {
        score = 0;
        superBullet=100;
        rockets.clear();
        bullets.clear();
        bulletRockets.clear();
        player.changeLocation(150, 150);
        player.reset();
    }

    private void initKeyboard() {
        key = new Key();
        requestFocus();
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_A) {
                    key.setKey_left(true);
                } else if (e.getKeyCode() == KeyEvent.VK_D) {
                    key.setKey_right(true);
                } else if (e.getKeyCode() == KeyEvent.VK_W) {
                    key.setKey_W(true);
                } else if (e.getKeyCode() == KeyEvent.VK_J) {
                    key.setKey_J(true);
                } else if (e.getKeyCode() == KeyEvent.VK_K) {
                    key.setKey_K(true);
                } else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    key.setKey_Enter(true);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_A) {
                    key.setKey_left(false);
                } else if (e.getKeyCode() == KeyEvent.VK_D) {
                    key.setKey_right(false);
                } else if (e.getKeyCode() == KeyEvent.VK_W) {
                    key.setKey_W(false);
                } else if (e.getKeyCode() == KeyEvent.VK_J) {
                    key.setKey_J(false);
                } else if (e.getKeyCode() == KeyEvent.VK_K) {
                    key.setKey_K(false);
                } else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    key.setKey_Enter(false);
                }
            }
      });
        new Thread(new Runnable() {
            @Override
            public void run() {
                float s = 0.5f;
                while (start) {
                    if (player.Alive()) {
                        float angle = player.getAngle();
                        if (key.isKey_left()) {
                            angle -= s;
                        }
                        if (key.isKey_right()) {
                            angle += s;
                        }
                        if (key.isKey_J() || key.isKey_K()) {
                            if (shotTime == 0) {
                                if (key.isKey_J()) {
                                    bullets.add(0, new Bullet(player.getX(), player.getY(), player.getAngle(),new ImageIcon("C:\\Users\\ASUS\\IdeaProjects\\test\\src\\Game\\laserSmall.png").getImage(),5,2f));

                                } else {
                                    if(superBullet>0){
                                        bullets.add(0, new Bullet(player.getX(), player.getY(), player.getAngle(),new ImageIcon("C:\\Users\\ASUS\\IdeaProjects\\test\\src\\Game\\bulletBig.png").getImage(),20,3f));
                                        superBullet--;
                                    }
                                }
                                sound.playSE(0);
                            }
                            shotTime++;
                            if (shotTime == 20) {
                                shotTime = 0;
                            }
                        } else {
                            shotTime = 0;
                        }
                        if (key.isKey_W()) {
                            player.speedup();
                        } else {
                            player.speeddown();
                        }
                        player.update();
                        player.changeAngle(angle);
                    } else {
                        if (key.isKey_Enter()) {
                            resetGame();
                        }
                    }
                    for (int i = 0; i < rockets.size(); i++) {
                        Rocket rocket = rockets.get(i);
                        if (rocket != null) {
                            rocket.update();
                            if (!rocket.check(width, height)) {
                                rockets.remove(rocket);
                            } else {
                                if (player.Alive()) {
                                    checkPlayer(rocket);
                                }
                            }
                        }
                    }
                    for(int i=0;i<bulletRockets.size();i++) {
                        BulletRocket BR = bulletRockets.get(i);
                        if(BR!=null){
                            BR.update();
                            if (!BR.check(width, height)) {
                                bulletRockets.remove(BR);
                            }
                            else {
                                if (player.Alive()) {
                                    checkplayer(BR);
                                }
                            }
                        }
                    }
                    sleep(5);
                }
            }
        }).start();
    }
    private void initBullets() {
        bullets = new ArrayList<>();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (start) {
                    for (int i = 0; i < bullets.size(); i++) {
                        Bullet bullet = bullets.get(i);
                        if (bullet != null) {
                            bullet.update();
                            checkBullets(bullet);
                            if (!bullet.check(width, height)) {
                                bullets.remove(bullet);
                            }
                        } else {
                            bullets.remove(bullet);
                        }
                    }
                    sleep(1);
                }
            }
        }).start();
    }

    private void checkBullets(Bullet bullet) {
        for (int i = 0; i < rockets.size(); i++) {
            Rocket rocket = rockets.get(i);
            if (rocket != null) {
                Area area = new Area(bullet.getShape());
                area.intersect(rocket.getRocketArea());
                if (!area.isEmpty()) {
                    if (!rocket.update(bullet.getSize())) {
                        score++;
                        rockets.remove(rocket);
                        sound.playSE(1);
                    } else {
                        sound.playSE(2);
                    }
                    bullets.remove(bullet);
                }
            }
        }
    }


    private void checkPlayer(Rocket rocket) {
        if (rocket != null) {
            Area area = new Area(player.getPlayerArea());
            area.intersect(rocket.getRocketArea());
            if (!area.isEmpty()) {
                double rocketHp = rocket.getHp();
                if (!rocket.update(player.getHp())) {
                    rockets.remove(rocket);
                    sound.playSE(1);
                }
                if (!player.update(rocketHp)) {
                    player.setAlive(false);
                    sound.playSE(1);
                }

            }
        }

    }
    private void checkPlayer(){
        if(player.getX()<0||player.getX()>width||player.getY()<0||player.getY()>height){
            player.setAlive(false);
        }
    }
    private void checkplayer(BulletRocket BR) {
        if (BR != null) {
            Area area = new Area(BR.getShape());
            area.intersect(player.getPlayerArea());
            if (!area.isEmpty()) {
                bulletRockets.remove(BR);
                if (!player.update(20)) {
                    player.setAlive(false);
                    sound.playSE(1);
                }
            }
        }
    }


    private void drawBackground() {
        Image space = new ImageIcon("C:\\Users\\ASUS\\IdeaProjects\\test\\src\\Game\\Space.png").getImage();
        g2.drawImage(space, 0, 0, width, height, null);
    }

    private void drawGame() {
        if (player.Alive()) {
            player.draw(g2);
        }
        for (int i = 0; i < bullets.size(); i++) {
            Bullet bullet = bullets.get(i);
            if (bullet != null) {
                bullet.draw(g2);
            }
        }
        for (int i = 0; i < rockets.size(); i++) {
            Rocket rocket = rockets.get(i);
            if (rocket != null) {
                rocket.draw(g2);
            }
        }
        for(int i=0;i<bulletRockets.size();i++){
            BulletRocket BR=bulletRockets.get(i);
            if(BR!=null) {
                BR.draw(g2);
            }
        }
        g2.setColor(Color.WHITE);
        g2.setFont(getFont().deriveFont(Font.BOLD, 15f));
        g2.drawString("Score : " + score, 10, 20);
        g2.drawString("Super bullet: "+superBullet,10,40);
        if (!player.Alive()) {
            String text = "GAME OVER";
            String textKey = "Press key enter to Continue ...";
            g2.setFont(getFont().deriveFont(Font.BOLD, 50f));
            FontMetrics fm = g2.getFontMetrics();
            Rectangle2D r2 = fm.getStringBounds(text, g2);
            double textWidth = r2.getWidth();
            double textHeight = r2.getHeight();
            double x = (width - textWidth) / 2;
            double y = (height - textHeight) / 2;
            g2.drawString(text, (int) x, (int) y + fm.getAscent());
            g2.setFont(getFont().deriveFont(Font.BOLD, 15f));
            fm = g2.getFontMetrics();
            r2 = fm.getStringBounds(textKey, g2);
            textWidth = r2.getWidth();
            textHeight = r2.getHeight();
            x = (width - textWidth) / 2;
            y = (height - textHeight) / 2;
            g2.drawString(textKey, (int) x, (int) y + fm.getAscent() + 50);
        }
    }

    private void render() {
        Graphics g = getGraphics();
        g.drawImage(image, 0, 0, null);
    }

    private void sleep(long speed) {
        try {
            Thread.sleep(speed);
        } catch (InterruptedException ex) {
            System.err.println(ex);
        }
    }
}