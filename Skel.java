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

// Set colors
Color foxOrange = new Color(255, 140, 0);  // Orange color for fox
Color foxWhite = new Color(255, 250, 240); // Light cream for belly/face
Color foxBlack = new Color(50, 30, 20);    // Dark brown/black for details

// Center of the canvas
int centerX = 320;
int centerY = 240;

// Draw fox body (simple oval)
g2.setColor(foxOrange);
g2.fillOval(centerX - 80, centerY - 20, 120, 60);

// Draw fox head (circle)
g2.fillOval(centerX - 120, centerY - 50, 80, 80);

// Draw white belly/chest
g2.setColor(foxWhite);
g2.fillOval(centerX - 70, centerY - 10, 100, 50);

// Draw white face area
g2.fillOval(centerX - 110, centerY - 40, 60, 60);

// Draw ears (two triangles)
g2.setColor(foxOrange);
int[] ear1X = {centerX - 100, centerX - 80, centerX - 90};
int[] ear1Y = {centerY - 50, centerY - 50, centerY - 80};
g2.fillPolygon(ear1X, ear1Y, 3);

int[] ear2X = {centerX - 60, centerX - 40, centerX - 50};
int[] ear2Y = {centerY - 50, centerY - 50, centerY - 80};
g2.fillPolygon(ear2X, ear2Y, 3);

// Draw inner ear (white/pink)
g2.setColor(foxWhite);
int[] innerEar1X = {centerX - 95, centerX - 82, centerX - 88};
int[] innerEar1Y = {centerY - 48, centerY - 48, centerY - 70};
g2.fillPolygon(innerEar1X, innerEar1Y, 3);

int[] innerEar2X = {centerX - 55, centerX - 42, centerX - 48};
int[] innerEar2Y = {centerY - 48, centerY - 48, centerY - 70};
g2.fillPolygon(innerEar2X, innerEar2Y, 3);

// Draw tail (fluffy curved shape)
g2.setColor(foxOrange);
GeneralPath tail = new GeneralPath();
tail.moveTo(centerX + 40, centerY);
tail.quadTo(centerX + 100, centerY - 40, centerX + 120, centerY - 20);
tail.quadTo(centerX + 110, centerY + 10, centerX + 80, centerY + 20);
tail.quadTo(centerX + 50, centerY + 15, centerX + 40, centerY);
tail.closePath();
g2.fill(tail);

// Draw simple eyes (two small black circles)
g2.setColor(foxBlack);
g2.fillOval(centerX - 95, centerY - 30, 8, 8);
g2.fillOval(centerX - 75, centerY - 30, 8, 8);

// Draw simple nose (small black triangle)
int[] noseX = {centerX - 85, centerX - 80, centerX - 75};
int[] noseY = {centerY - 10, centerY - 5, centerY - 10};
g2.fillPolygon(noseX, noseY, 3);

// Draw simple mouth (two small lines)
g2.setStroke(new BasicStroke(2));
g2.drawLine(centerX - 80, centerY - 5, centerX - 70, centerY);
g2.drawLine(centerX - 80, centerY - 5, centerX - 70, centerY + 5);

    }
}
