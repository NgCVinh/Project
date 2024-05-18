package Game.Rocket;

import Game.Object.HP;
import Game.Object.HP_Render;
import Game.Object.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.Path2D;
import java.awt.geom.Rectangle2D;

public class Rocket extends HP_Render {
    public static final double Rocket_size=40;
    private double x;
    private double y;
    private float angle;
    private final float speed=0.4f;
    private final Image image;
    private final Area rocketArea;
    public Rocket(){
        super(new HP(50,50));
        this.image=new ImageIcon(getClass().getResource("/Game/Image/enemy.png")).getImage();
        this.angle=0;
        Path2D p=new Path2D.Double();
        p.moveTo(0,Rocket_size/2);
        p.lineTo(15,10);
        p.lineTo(Rocket_size+10,13);
        p.lineTo(Rocket_size-5,Rocket_size-13);
        p.lineTo(15,Rocket_size-10);
        this.rocketArea=new Area(p);
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
    public void draw(Graphics2D graphics2D){
        //draw image and rotate
        AffineTransform oldTransform=graphics2D.getTransform();
        graphics2D.translate(x,y);
        AffineTransform trans=new AffineTransform();
        trans.rotate(Math.toRadians(angle),Rocket_size/2,Rocket_size/2);
        graphics2D.drawImage(image,trans,null);
        graphics2D.setTransform(oldTransform);
        //draw hp render
        graphics2D.setColor(Color.WHITE);
        graphics2D.fill(new Rectangle2D.Double(x,y-10, Player.player_size,3));
        graphics2D.setColor(Color.RED);
        double hpSize = hp.getCurrent_HP() / hp.getMax_HP() * Player.player_size;
        graphics2D.fill(new Rectangle2D.Double(x, y-10, hpSize, 3));
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
    public Area getRocketArea(){
        AffineTransform aft=new AffineTransform();
        aft.translate(x,y);
        aft.rotate(Math.toRadians(angle),Rocket_size/2,Rocket_size/2);
        return new Area(aft.createTransformedShape(rocketArea));
    }
    public boolean check(int width,int height){
        if(x>width||y>height){
            return false;
        }
        else{
            return true;
        }
    }
}
