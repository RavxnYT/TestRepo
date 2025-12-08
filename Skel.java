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

// Set rendering hints for smooth lines
g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

// Center of the canvas
int centerX = 320;
int centerY = 240;

// Draw a simple, minimalist fox
// Body (oval)
g2.setColor(new Color(255, 140, 0)); // Orange
Ellipse2D body = new Ellipse2D.Double(centerX - 80, centerY - 20, 160, 80);
g2.fill(body);

// Head (circle)
g2.setColor(new Color(255, 140, 0)); // Orange
Ellipse2D head = new Ellipse2D.Double(centerX + 60, centerY - 50, 80, 80);
g2.fill(head);

// Ears (triangles)
int[] ear1X = {centerX + 100, centerX + 120, centerX + 110};
int[] ear1Y = {centerY - 30, centerY - 50, centerY - 60};
g2.setColor(new Color(255, 140, 0)); // Orange
g2.fillPolygon(ear1X, ear1Y, 3);

int[] ear2X = {centerX + 120, centerX + 140, centerX + 130};
int[] ear2Y = {centerY - 30, centerY - 50, centerY - 60};
g2.fillPolygon(ear2X, ear2Y, 3);

// Inner ears (pink)
int[] innerEar1X = {centerX + 105, centerX + 118, centerX + 112};
int[] innerEar1Y = {centerY - 35, centerY - 52, centerY - 58};
g2.setColor(new Color(255, 192, 203)); // Pink
g2.fillPolygon(innerEar1X, innerEar1Y, 3);

int[] innerEar2X = {centerX + 125, centerX + 137, centerX + 131};
int[] innerEar2Y = {centerY - 35, centerY - 52, centerY - 58};
g2.fillPolygon(innerEar2X, innerEar2Y, 3);

// Snout (small oval)
g2.setColor(new Color(255, 140, 0)); // Orange
Ellipse2D snout = new Ellipse2D.Double(centerX + 130, centerY - 5, 30, 20);
g2.fill(snout);

// Nose (black triangle)
int[] noseX = {centerX + 160, centerX + 155, centerX + 155};
int[] noseY = {centerY + 5, centerY, centerY + 10};
g2.setColor(Color.BLACK);
g2.fillPolygon(noseX, noseY, 3);

// Eyes (black circles)
g2.setColor(Color.BLACK);
g2.fillOval(centerX + 100, centerY - 20, 8, 8);
g2.fillOval(centerX + 120, centerY - 20, 8, 8);

// Tail (fluffy, curved)
g2.setColor(new Color(255, 140, 0)); // Orange
GeneralPath tail = new GeneralPath();
tail.moveTo(centerX - 80, centerY + 20);
tail.curveTo(centerX - 120, centerY + 40, centerX - 140, centerY + 20, centerX - 120, centerY);
tail.curveTo(centerX - 100, centerY - 20, centerX - 80, centerY - 10, centerX - 80, centerY + 20);
tail.closePath();
g2.fill(tail);

// Legs (simple rectangles)
g2.setColor(new Color(255, 140, 0)); // Orange
// Front legs
g2.fillRect(centerX - 40, centerY + 60, 25, 40);
g2.fillRect(centerX + 20, centerY + 60, 25, 40);
// Back legs
g2.fillRect(centerX - 60, centerY + 60, 25, 40);
g2.fillRect(centerX + 40, centerY + 60, 25, 40);

// Paws (small circles)
g2.setColor(new Color(200, 100, 0)); // Darker orange
g2.fillOval(centerX - 42, centerY + 95, 20, 15);
g2.fillOval(centerX + 22, centerY + 95, 20, 15);
g2.fillOval(centerX - 62, centerY + 95, 20, 15);
g2.fillOval(centerX + 42, centerY + 95, 20, 15);

    }
}
