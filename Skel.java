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

// Center of the canvas
int centerX = 320;
int centerY = 240;

// Draw a simple fox - minimalist but perfect
// Fox body (orange/brown)
g2.setColor(new Color(255, 140, 0)); // Orange color
Ellipse2D body = new Ellipse2D.Double(centerX - 80, centerY - 20, 160, 100);
g2.fill(body);

// Fox head (slightly smaller circle)
g2.setColor(new Color(255, 140, 0));
Ellipse2D head = new Ellipse2D.Double(centerX + 60, centerY - 50, 80, 80);
g2.fill(head);

// Fox snout (pointed triangle)
g2.setColor(new Color(255, 200, 150)); // Lighter orange/cream
int[] snoutX = {centerX + 140, centerX + 155, centerX + 140};
int[] snoutY = {centerY + 10, centerY + 10, centerY + 25};
g2.fillPolygon(snoutX, snoutY, 3);

// Fox ears (two triangles)
g2.setColor(new Color(255, 140, 0));
// Left ear
int[] ear1X = {centerX + 70, centerX + 85, centerX + 75};
int[] ear1Y = {centerY - 50, centerY - 50, centerY - 70};
g2.fillPolygon(ear1X, ear1Y, 3);
// Right ear
int[] ear2X = {centerX + 110, centerX + 125, centerX + 115};
int[] ear2Y = {centerY - 50, centerY - 50, centerY - 70};
g2.fillPolygon(ear2X, ear2Y, 3);

// Inner ear (pink/light)
g2.setColor(new Color(255, 192, 203)); // Pink
int[] innerEar1X = {centerX + 72, centerX + 82, centerX + 76};
int[] innerEar1Y = {centerY - 48, centerY - 48, centerY - 62};
g2.fillPolygon(innerEar1X, innerEar1Y, 3);
int[] innerEar2X = {centerX + 112, centerX + 122, centerX + 116};
int[] innerEar2Y = {centerY - 48, centerY - 48, centerY - 62};
g2.fillPolygon(innerEar2X, innerEar2Y, 3);

// Fox eyes (two small black circles)
g2.setColor(Color.BLACK);
g2.fillOval(centerX + 85, centerY - 5, 8, 8);
g2.fillOval(centerX + 107, centerY - 5, 8, 8);

// Fox tail (fluffy, curved)
g2.setColor(new Color(255, 140, 0));
GeneralPath tail = new GeneralPath();
tail.moveTo(centerX - 80, centerY + 30);
tail.curveTo(centerX - 120, centerY + 10, 
             centerX - 150, centerY - 20,
             centerX - 140, centerY - 50);
tail.curveTo(centerX - 130, centerY - 30,
             centerX - 110, centerY - 10,
             centerX - 80, centerY + 30);
tail.closePath();
g2.fill(tail);

// Fox legs (four simple rectangles)
g2.setColor(new Color(200, 100, 0)); // Darker orange
// Front left leg
g2.fillRect(centerX - 40, centerY + 60, 25, 40);
// Front right leg
g2.fillRect(centerX + 15, centerY + 60, 25, 40);
// Back left leg
g2.fillRect(centerX - 60, centerY + 70, 25, 40);
// Back right leg
g2.fillRect(centerX + 35, centerY + 70, 25, 40);

// White chest patch
g2.setColor(Color.WHITE);
Ellipse2D chest = new Ellipse2D.Double(centerX - 20, centerY + 10, 60, 50);
g2.fill(chest);

    }
}
