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

// Set rendering hints for smooth drawing
g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

// Fox colors
Color foxOrange = new Color(255, 140, 0);  // Orange body
Color foxWhite = new Color(255, 255, 255);  // White chest/face
Color foxBlack = new Color(0, 0, 0);        // Black nose/eyes
Color foxDarkOrange = new Color(200, 100, 0); // Darker orange for tail tip

// Center of the canvas
int centerX = 320;
int centerY = 240;

// Draw tail (curved shape behind body)
GeneralPath tail = new GeneralPath();
tail.moveTo(centerX + 80, centerY + 20);
tail.quadTo(centerX + 120, centerY - 40, centerX + 140, centerY - 20);
tail.quadTo(centerX + 130, centerY + 10, centerX + 100, centerY + 30);
tail.closePath();
g2.setColor(foxOrange);
g2.fill(tail);
// Tail tip (darker)
Ellipse2D tailTip = new Ellipse2D.Double(centerX + 135, centerY - 25, 15, 15);
g2.setColor(foxDarkOrange);
g2.fill(tailTip);

// Draw body (ellipse)
Ellipse2D body = new Ellipse2D.Double(centerX - 40, centerY - 20, 80, 50);
g2.setColor(foxOrange);
g2.fill(body);

// Draw white chest
Ellipse2D chest = new Ellipse2D.Double(centerX - 30, centerY - 10, 50, 35);
g2.setColor(foxWhite);
g2.fill(chest);

// Draw head (circle)
Ellipse2D head = new Ellipse2D.Double(centerX - 50, centerY - 50, 60, 60);
g2.setColor(foxOrange);
g2.fill(head);

// Draw white face area
Ellipse2D face = new Ellipse2D.Double(centerX - 45, centerY - 45, 50, 50);
g2.setColor(foxWhite);
g2.fill(face);

// Draw ears (triangles)
int[] ear1X = {centerX - 30, centerX - 20, centerX - 10};
int[] ear1Y = {centerY - 50, centerY - 70, centerY - 50};
Polygon ear1 = new Polygon(ear1X, ear1Y, 3);
g2.setColor(foxOrange);
g2.fill(ear1);
// Inner ear (white)
int[] innerEar1X = {centerX - 28, centerX - 20, centerX - 12};
int[] innerEar1Y = {centerY - 50, centerY - 65, centerY - 50};
Polygon innerEar1 = new Polygon(innerEar1X, innerEar1Y, 3);
g2.setColor(foxWhite);
g2.fill(innerEar1);

int[] ear2X = {centerX + 10, centerX + 20, centerX + 30};
int[] ear2Y = {centerY - 50, centerY - 70, centerY - 50};
Polygon ear2 = new Polygon(ear2X, ear2Y, 3);
g2.setColor(foxOrange);
g2.fill(ear2);
// Inner ear (white)
int[] innerEar2X = {centerX + 12, centerX + 20, centerX + 28};
int[] innerEar2Y = {centerY - 50, centerY - 65, centerY - 50};
Polygon innerEar2 = new Polygon(innerEar2X, innerEar2Y, 3);
g2.setColor(foxWhite);
g2.fill(innerEar2);

// Draw eyes (small circles)
Ellipse2D eye1 = new Ellipse2D.Double(centerX - 25, centerY - 30, 8, 8);
g2.setColor(foxBlack);
g2.fill(eye1);

Ellipse2D eye2 = new Ellipse2D.Double(centerX + 5, centerY - 30, 8, 8);
g2.setColor(foxBlack);
g2.fill(eye2);

// Draw nose (small triangle)
int[] noseX = {centerX - 5, centerX + 5, centerX};
int[] noseY = {centerY - 15, centerY - 15, centerY - 5};
Polygon nose = new Polygon(noseX, noseY, 3);
g2.setColor(foxBlack);
g2.fill(nose);

// Draw legs (simple rectangles)
// Front legs
Rectangle2D leg1 = new Rectangle2D.Double(centerX - 30, centerY + 30, 15, 30);
g2.setColor(foxOrange);
g2.fill(leg1);

Rectangle2D leg2 = new Rectangle2D.Double(centerX + 5, centerY + 30, 15, 30);
g2.setColor(foxOrange);
g2.fill(leg2);

// Back legs
Rectangle2D leg3 = new Rectangle2D.Double(centerX - 20, centerY + 30, 15, 30);
g2.setColor(foxOrange);
g2.fill(leg3);

Rectangle2D leg4 = new Rectangle2D.Double(centerX + 15, centerY + 30, 15, 30);
g2.setColor(foxOrange);
g2.fill(leg4);

    }
}
