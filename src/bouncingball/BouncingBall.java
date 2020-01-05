/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bouncingball;

import java.awt.event.ActionListener;
import javafx.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

/**
 *
 * @author faizmomin
 */
public class BouncingBall extends JFrame {

    public BouncingBall() {
        initUI();
    }

    //create the custom JFrame
    private void initUI() {
        //set title of the JFrame
        setTitle("Bouncing Ball");
        //add a custom JPanel to draw on
        add(new DrawingSurface());
        //set the size of the window
        setSize(500, 500);
        //tell the JFrame what to do when closed
        //this is important if our application has multiple windows
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        //make sure that all UI updates are concurrency safe (related to multi threading)
        //much more detailed http://www.javamex.com/tutorials/threads/invokelater.shtml
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                //instantiate the main window
                BouncingBall windowFrame = new BouncingBall();
                //make sure it can be seen
                windowFrame.setVisible(true);
            }
        });

    }

}
