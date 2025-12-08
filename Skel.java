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

// Set rendering hints for smoother drawing
g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

// Background
g2.setColor(new Color(240, 240, 240));
g2.fillRect(0, 0, getWidth(), getHeight());

// Fox colors
Color foxOrange = new Color(255, 140, 0);  // Orange body
Color foxWhite = new Color(255, 255, 255);  // White chest/face
Color foxBlack = new Color(0, 0, 0);        // Black details

// Center position
int centerX = getWidth() / 2;
int centerY = getHeight() / 2;

// Draw fox body (oval)
g2.setColor(foxOrange);
g2.fillOval(centerX - 80, centerY - 20, 160, 100);

// Draw head (circle)
g2.fillOval(centerX - 50, centerY - 100, 100, 80);

// Draw white chest
g2.setColor(foxWhite);
g2.fillOval(centerX - 60, centerY - 10, 80, 60);

// Draw white face mask
g2.fillOval(centerX - 40, centerY - 90, 60, 50);

// Draw ears (triangles)
g2.setColor(foxOrange);
int[] ear1X = {centerX - 30, centerX - 10, centerX - 20};
int[] ear1Y = {centerY - 100, centerY - 100, centerY - 120};
g2.fillPolygon(ear1X, ear1Y, 3);

int[] ear2X = {centerX + 10, centerX + 30, centerX + 20};
int[] ear2Y = {centerY - 100, centerY - 100, centerY - 120};
g2.fillPolygon(ear2X, ear2Y, 3);

// Draw inner ear (white)
g2.setColor(foxWhite);
int[] innerEar1X = {centerX - 25, centerX - 12, centerX - 18};
int[] innerEar1Y = {centerY - 100, centerY - 100, centerY - 115};
g2.fillPolygon(innerEar1X, innerEar1Y, 3);

int[] innerEar2X = {centerX + 12, centerX + 25, centerX + 18};
int[] innerEar2Y = {centerY - 100, centerY - 100, centerY - 115};
g2.fillPolygon(innerEar2X, innerEar2Y, 3);

// Draw tail (fluffy)
g2.setColor(foxOrange);
g2.fillOval(centerX + 60, centerY - 30, 80, 40);
g2.fillOval(centerX + 80, centerY - 50, 60, 50);
g2.fillOval(centerX + 100, centerY - 40, 50, 40);

// Draw tail tip (white)
g2.setColor(foxWhite);
g2.fillOval(centerX + 120, centerY - 45, 30, 25);

// Draw legs (simple rectangles)
g2.setColor(foxOrange);
g2.fillRect(centerX - 60, centerY + 60, 25, 40);
g2.fillRect(centerX - 20, centerY + 60, 25, 40);
g2.fillRect(centerX + 20, centerY + 60, 25, 40);
g2.fillRect(centerX + 60, centerY + 60, 25, 40);

// Draw eyes (black circles)
g2.setColor(foxBlack);
g2.fillOval(centerX - 25, centerY - 75, 12, 12);
g2.fillOval(centerX + 13, centerY - 75, 12, 12);

// Draw nose (black triangle)
int[] noseX = {centerX, centerX - 5, centerX + 5};
int[] noseY = {centerY - 60, centerY - 55, centerY - 55};
g2.fillPolygon(noseX, noseY, 3);

// Draw mouth (simple line)
g2.setStroke(new BasicStroke(2));
g2.drawLine(centerX, centerY - 55, centerX, centerY - 45);
g2.drawLine(centerX, centerY - 45, centerX - 8, centerY - 40);
g2.drawLine(centerX, centerY - 45, centerX + 8, centerY - 40);
        
    }
}
