package Game.Rocket;

import Game.Rocket.Rocket;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;

public class BulletRocket {
    private double x;
    private double y;
    private final float angle;
    private double size;
    private int speed;
    private final Image image;
    public BulletRocket(double x,double y,float angle,double size,int speed,Image image){
        x+= Rocket.Rocket_size/2;
        y+=Rocket.Rocket_size/2;
        this.x=x;
        this.y=y;
        this.angle=angle;
        this.size=size;
        this.speed=speed;
        this.image=image;
    }
    public void update(){
        x+=Math.cos(Math.toRadians(angle))*speed;
        y+=Math.sin(Math.toRadians(angle))*speed;
    }
    public boolean check(int width,int height){
        if(x>width||y>height)
            return false;
        else {
            return true;
        }
    }
    public void draw(Graphics2D graphics2D){
        AffineTransform oldTransform=graphics2D.getTransform();
        graphics2D.drawImage(image,(int) x,(int) y,null);
        graphics2D.setTransform(oldTransform);
    }

    public double getY() {
        return y;
    }

    public double getX() {
        return x;
    }

    public double getSize() {
        return size;
    }
    public double getCenterX(){
        return x+(size/2);
    }
    public double getCenterY(){
        return y+(size/2);
    }
    public Area getShape(){
        return new Area(new Ellipse2D.Double(x,y,size,size));
    }
}
