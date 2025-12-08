/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.geom.*;
import java.util.Random;

/**
 *
 * @author eid.emary
 */
public class Skel extends JApplet{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        JFrame frame=new JFrame();
        frame.setTitle("hello");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JApplet applete =new Skel();
        applete.init();
        frame.getContentPane().add(applete);
        frame.pack();
        frame.setVisible(true);
    }
    public void init(){
        JPanel panel=new JApp1Panel();
        getContentPane().add(panel);
    }
    
}
class JApp1Panel extends JPanel{
public JApp1Panel(){
    setPreferredSize(new Dimension(640,480));
}
public void paintComponent(Graphics g){
super.paintComponent(g);
Graphics2D g2=(Graphics2D) g;
g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

// Colors
Color orange = new Color(245, 140, 50);
Color cream = new Color(255, 245, 220);
Color black = Color.BLACK;

// Center position
int centerX = 320;
int centerY = 280;

// Draw tail
g2.setColor(orange);
int[] tailXPoints = {centerX - 60, centerX - 100, centerX - 80, centerX - 40};
int[] tailYPoints = {centerY + 20, centerY - 20, centerY - 60, centerY - 10};
g2.fillPolygon(tailXPoints, tailYPoints, 4);

// Tail tip (cream)
g2.setColor(cream);
int[] tailTipX = {centerX - 100, centerX - 80, centerX - 90};
int[] tailTipY = {centerY - 20, centerY - 60, centerY - 50};
g2.fillPolygon(tailTipX, tailTipY, 3);

// Draw body
g2.setColor(orange);
Ellipse2D.Double body = new Ellipse2D.Double(centerX - 50, centerY, 100, 80);
g2.fill(body);

// Draw head
Ellipse2D.Double head = new Ellipse2D.Double(centerX - 45, centerY - 50, 90, 75);
g2.fill(head);

// Draw ears
int[] leftEarX = {centerX - 30, centerX - 15, centerX - 35};
int[] leftEarY = {centerY - 50, centerY - 85, centerY - 75};
g2.fillPolygon(leftEarX, leftEarY, 3);

int[] rightEarX = {centerX + 15, centerX + 30, centerX + 35};
int[] rightEarY = {centerY - 85, centerY - 50, centerY - 75};
g2.fillPolygon(rightEarX, rightEarY, 3);

// Ear inner (cream)
g2.setColor(cream);
int[] leftEarInnerX = {centerX - 25, centerX - 18, centerX - 30};
int[] leftEarInnerY = {centerY - 52, centerY - 75, centerY - 70};
g2.fillPolygon(leftEarInnerX, leftEarInnerY, 3);

int[] rightEarInnerX = {centerX + 18, centerX + 25, centerX + 30};
int[] rightEarInnerY = {centerY - 75, centerY - 52, centerY - 70};
g2.fillPolygon(rightEarInnerX, rightEarInnerY, 3);

// Draw face (cream)
int[] faceX = {centerX - 30, centerX + 30, centerX + 20, centerX, centerX - 20};
int[] faceY = {centerY - 20, centerY - 20, centerY + 15, centerY + 25, centerY + 15};
g2.fillPolygon(faceX, faceY, 5);

// Draw chest (cream)
Ellipse2D.Double chest = new Ellipse2D.Double(centerX - 25, centerY + 20, 50, 40);
g2.fill(chest);

// Draw black legs
g2.setColor(black);
Ellipse2D.Double leftLeg = new Ellipse2D.Double(centerX - 30, centerY + 60, 20, 25);
g2.fill(leftLeg);
Ellipse2D.Double rightLeg = new Ellipse2D.Double(centerX + 10, centerY + 60, 20, 25);
g2.fill(rightLeg);

// Draw eyes
g2.setColor(black);
Ellipse2D.Double leftEye = new Ellipse2D.Double(centerX - 20, centerY - 15, 8, 10);
g2.fill(leftEye);
Ellipse2D.Double rightEye = new Ellipse2D.Double(centerX + 12, centerY - 15, 8, 10);
g2.fill(rightEye);

// Draw nose
Ellipse2D.Double nose = new Ellipse2D.Double(centerX - 3, centerY + 2, 6, 5);
g2.fill(nose);

// Draw smile
g2.setStroke(new BasicStroke(2));
Arc2D.Double smile = new Arc2D.Double(centerX - 10, centerY, 20, 10, 180, 180, Arc2D.OPEN);
g2.draw(smile);

    }
}
