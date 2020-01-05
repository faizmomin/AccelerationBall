/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bouncingball;

import java.awt.Graphics2D;

/**
 *
 * @author faizmomin
 */
public class Ball {
    double xPos, yPos, xVel, yVel;
    int vertVel = -5;
    
    double accel = 0.04;
    
    public Ball(){
        xPos = 10;
        yPos = 10;
        xVel = 1;
        yVel = 0;
    }
    
    public Ball(int xPos, int yPos){
        this();
        this.xPos = xPos;
        this.yPos = yPos;
    }
    
    public Ball(int xPos, int yPos, int vel){
        this();
        this.xPos = xPos;
        this.yPos = yPos;
        xVel = vel;
        yVel = vel;
    }
    
    public double getXPos(){
        return xPos;
    }
    
    public double getYPos(){
        return yPos;
    }
    
    public void setXVel(double x){
        xVel = x;
    }
    
    public void setYVel(double y){
        yVel = y;
    }
    
    public double getXVel(){
        return xVel;
    }
    
    public double getYVel(){
        return yVel;
    }
    
    public void update(){
        if(xPos >=(500-25) || xPos <= 25){
            xVel *= -1;
        }
        
        if(yPos<= 25){
            yVel *= -1;
        }
        
        if(yPos >= (500-45)){
            yVel = vertVel;
        }
        
        xPos += xVel;
        yPos += yVel;
        yVel += accel;
    }
    
    public boolean checkCollision(Ball b){
        double x = b.getXPos();
        double y = b.getYPos();
        double xDist = Math.pow(x - xPos, 2);
        double yDist = Math.pow(y - yPos, 2);
        double distance = Math.pow(xDist + yDist,0.5);
        
        if(distance <= 50){
            return true;
        }else{
            return false;
        }
    }
    
    public void draw(Graphics2D g2d){
        g2d.fillOval((int)(xPos-25), (int)(yPos-25), 50, 50);
    }
    
    
}
