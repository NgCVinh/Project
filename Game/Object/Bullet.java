package Game.Object;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;

public class Bullet {
    private double x;
    private double y;
    private final float angle;
    private double size;
    private float speed;
    private final Image image;
    public Bullet(double x,double y,float angle,Image image,double size,float speed){
        x+= Player.player_size/2;
        y+=Player.player_size/2;
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
        if(x>width||y>height){
            return false;
        }
        else{
            return true;
        }
    }
    public void draw(Graphics2D g2){
        AffineTransform oldTransform=g2.getTransform();
        g2.drawImage(image, (int) x+3, (int) y-6, null);
        g2.setTransform(oldTransform);
    }
    public double getX(){
        return x;
    }
    public double getY(){
        return y;
    }
    public double getSize(){
        return size;
    }
    public double getCenterX(){
        return x+size/2;
    }
    public double getCenterY(){
        return y+size/2;
    }
    public Area getShape(){
        return new Area(new Ellipse2D.Double(x,y,size,size));
    }
}
