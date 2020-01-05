/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bouncingball;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author faizmomin
 */
public class DrawingSurface extends JPanel implements ActionListener{
    Timer tm = new Timer(5, this);
    int xPos = 200; 
    int yPos = 75;
    int xVel = 1;
    int yVel = 1;
    
    int rCounter = 1;
    int gCounter = 1;
    int bCounter = 1;
    int rColor = 0;
    int gColor = 170;
    int bColor = 240;
    
    double newXVel1;
    double newXVel2;
    double newYVel1;
    double newYVel2;
    
    Vector2D tangent;
    
    Ball b1 = new Ball(100,200);
    Ball b2 = new Ball(300,250, 2);
    Ball b3 = new Ball(100, 200);
    
    Ball balls[] = {b1,b2,b3};
    
    
    private void doDrawing(Graphics g){
        Graphics2D g2d = (Graphics2D)(g);
        
        b1.draw(g2d);
        b1.update();
        
        b2.draw(g2d);
        b2.update();
        
        if(b1.checkCollision(b2)){
            //tangent.set(b2.getYPos() - b1.getYPos(), -(b2.getXPos() - b1.getXPos()));
            //tangent.normalize();
            
            //THIS IS THE OLD GLITCHY COLLISION CODE
            newXVel1 = b1.getXVel();
            newXVel2 = b2.getXVel();
            newYVel1 = b1.getYVel();
            newYVel2 = b2.getYVel();
            
            b1.setXVel(newXVel2);
            b1.setYVel(newYVel2);
            
            b2.setXVel(newXVel1);
            b2.setYVel(newYVel1);
            
           
        }
        
        tm.start();
    }
    
    public void actionPerformed(ActionEvent e){
        repaint();
    }
    
    //overrides paintComponent in JPanel class
    //performs custom painting
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);//does the necessary work to prepare the panel for drawing
        doDrawing(g);
    }
}
