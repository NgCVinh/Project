package Game.Object;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.Path2D;
import java.awt.geom.Rectangle2D;

public class Player extends HP_Render {
    public static final double player_size=64;
    private double x;
    private double y;
    private float angle=0f;
    private final Image image;
    private final float Max_speed=1f;
    private Area playerArea;
    private float speed=0f;
    private boolean speedup;
    private boolean alive;
    public Player(){
        super(new HP(500,500));
        this.image=new ImageIcon("C:\\Users\\ASUS\\IdeaProjects\\test\\src\\Game\\ship.gif").getImage();
        Path2D p=new Path2D.Double();
        p.moveTo(0,45);
        p.lineTo(20,45);
        p.lineTo(player_size+15,player_size/2);
        p.lineTo(45,player_size-5);
        p.lineTo(0,player_size-15);

        playerArea=new Area(new Rectangle2D.Double(x,y,player_size,player_size));
    }
    public void changeLocation(double x,double y){
        this.x=x;
        this.y=y;
    }
    public void update(){
        x+=Math.cos(Math.toRadians(angle))*speed;
        y+=Math.sin(Math.toRadians(angle))*speed;
    }
    public void changeAngle(float angle){
        if(angle<0){
            angle=359;
        }
        else if(angle>359){
            angle=0;
        }
        this.angle=angle;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
    public float getAngle(){
        return angle;
    }
    public void draw(Graphics2D graphics2D){
        //draw spaceship
        AffineTransform oldTransform=graphics2D.getTransform();
        graphics2D.translate(x,y);
        AffineTransform trans=new AffineTransform();
        trans.rotate(Math.toRadians(angle+90),player_size/2,player_size/2);
        graphics2D.drawImage(image,trans,null);
        graphics2D.setTransform(oldTransform);
        //draw hpRender
        graphics2D.setColor(Color.WHITE);
        graphics2D.fill(new Rectangle2D.Double(x,y-10,Player.player_size,3));
        graphics2D.setColor(Color.GREEN);
        double hpSize = hp.getCurrent_HP() / hp.getMax_HP() * Player.player_size;
        graphics2D.fill(new Rectangle2D.Double(x, y-10, hpSize, 3));
    }
    public Area getPlayerArea(){
        AffineTransform aft=new AffineTransform();
        aft.translate(x,y);
        aft.rotate(Math.toRadians(angle),player_size/2,player_size/2);
        return new Area(aft.createTransformedShape(playerArea));
    }
    public void speedup(){
        this.speedup=true;
        if(speed>Max_speed){
            speed=Max_speed;
        }
        else{
            speed+=0.01f;
        }

    }
    public void speeddown(){
        this.speedup=false;
        if(speed<0){
            speed=0;
        }
        else{
            speed-=0.003f;
        }
    }
    public boolean Alive(){
        return alive;
    }
    public void setAlive(boolean alive){
        this.alive=alive;
    }
    public void reset(){
        alive=true;
        resetHp();
        angle=0f;
        speed=0;
    }
}
