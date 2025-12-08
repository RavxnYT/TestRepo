/*
 * Simple Fox Drawing in Java Graphics2D
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.geom.*;

public class Skel extends JApplet {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setTitle("Simple Fox");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JApplet applet = new Skel();
        applet.init();
        frame.getContentPane().add(applet);
        frame.pack();
        frame.setVisible(true);
    }

    public void init() {
        JPanel panel = new JApp1Panel();
        getContentPane().add(panel);
    }
}

class JApp1Panel extends JPanel {
    
    // Colors
    Color orange = new Color(227, 119, 47);
    Color cream = new Color(255, 248, 230);
    Color black = Color.BLACK;
    Color outline = new Color(45, 45, 45);
    
    public JApp1Panel() {
        setPreferredSize(new Dimension(640, 480));
        setBackground(Color.WHITE);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        
        // Enable anti-aliasing for smooth edges
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setStroke(new BasicStroke(3f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        
        int cx = 320; // center x
        int cy = 240; // center y
        
        // Draw tail (behind body)
        drawTail(g2, cx - 100, cy + 20);
        
        // Draw body
        drawBody(g2, cx, cy + 60);
        
        // Draw head
        drawHead(g2, cx + 20, cy - 20);
        
        // Draw front feet
        drawFeet(g2, cx + 20, cy + 130);
    }
    
    void drawTail(Graphics2D g2, int x, int y) {
        // Tail shape - big fluffy tail
        GeneralPath tail = new GeneralPath();
        tail.moveTo(x + 60, y + 80);
        tail.curveTo(x - 20, y + 100, x - 60, y + 60, x - 50, y + 10);
        tail.curveTo(x - 40, y - 50, x + 10, y - 80, x + 40, y - 70);
        tail.curveTo(x + 50, y - 65, x + 55, y - 55, x + 45, y - 40);
        tail.curveTo(x + 30, y - 20, x + 20, y + 10, x + 30, y + 40);
        tail.curveTo(x + 40, y + 60, x + 50, y + 70, x + 60, y + 80);
        tail.closePath();
        
        g2.setColor(orange);
        g2.fill(tail);
        g2.setColor(outline);
        g2.draw(tail);
        
        // Cream tip on tail
        GeneralPath tailTip = new GeneralPath();
        tailTip.moveTo(x + 45, y - 40);
        tailTip.curveTo(x + 55, y - 55, x + 50, y - 65, x + 40, y - 70);
        tailTip.curveTo(x + 10, y - 80, x - 40, y - 50, x - 50, y + 10);
        tailTip.curveTo(x - 55, y + 30, x - 45, y + 45, x - 30, y + 50);
        tailTip.curveTo(x - 10, y + 30, x + 10, y - 10, x + 30, y - 20);
        tailTip.curveTo(x + 40, y - 30, x + 42, y - 35, x + 45, y - 40);
        tailTip.closePath();
        
        g2.setColor(cream);
        g2.fill(tailTip);
        g2.setColor(outline);
        g2.draw(tailTip);
    }
    
    void drawBody(Graphics2D g2, int x, int y) {
        // Back leg (sitting position) - rounded shape
        Ellipse2D backLeg = new Ellipse2D.Double(x - 60, y + 20, 70, 55);
        g2.setColor(orange);
        g2.fill(backLeg);
        g2.setColor(outline);
        g2.draw(backLeg);
        
        // Main body - oval shape
        Ellipse2D body = new Ellipse2D.Double(x - 30, y - 40, 80, 100);
        g2.setColor(orange);
        g2.fill(body);
        g2.setColor(outline);
        g2.draw(body);
        
        // Chest - cream colored
        Ellipse2D chest = new Ellipse2D.Double(x - 10, y - 10, 50, 70);
        g2.setColor(cream);
        g2.fill(chest);
        g2.setColor(outline);
        g2.draw(chest);
    }
    
    void drawHead(Graphics2D g2, int x, int y) {
        // Left ear (orange outer)
        int[] earLX = {x - 45, x - 25, x - 10};
        int[] earLY = {y - 55, y - 95, y - 45};
        Polygon leftEar = new Polygon(earLX, earLY, 3);
        g2.setColor(orange);
        g2.fill(leftEar);
        g2.setColor(outline);
        g2.draw(leftEar);
        
        // Left ear inner (cream)
        int[] earLIX = {x - 40, x - 27, x - 18};
        int[] earLIY = {y - 58, y - 82, y - 52};
        Polygon leftEarInner = new Polygon(earLIX, earLIY, 3);
        g2.setColor(cream);
        g2.fill(leftEarInner);
        
        // Right ear (orange outer)
        int[] earRX = {x + 45, x + 25, x + 10};
        int[] earRY = {y - 55, y - 95, y - 45};
        Polygon rightEar = new Polygon(earRX, earRY, 3);
        g2.setColor(orange);
        g2.fill(rightEar);
        g2.setColor(outline);
        g2.draw(rightEar);
        
        // Right ear inner (cream)
        int[] earRIX = {x + 40, x + 27, x + 18};
        int[] earRIY = {y - 58, y - 82, y - 52};
        Polygon rightEarInner = new Polygon(earRIX, earRIY, 3);
        g2.setColor(cream);
        g2.fill(rightEarInner);
        
        // Head shape - wider at top, pointed at bottom
        GeneralPath head = new GeneralPath();
        head.moveTo(x, y + 50);  // chin
        head.curveTo(x - 30, y + 40, x - 55, y + 10, x - 55, y - 20);
        head.curveTo(x - 55, y - 50, x - 35, y - 60, x, y - 55);
        head.curveTo(x + 35, y - 60, x + 55, y - 50, x + 55, y - 20);
        head.curveTo(x + 55, y + 10, x + 30, y + 40, x, y + 50);
        head.closePath();
        
        g2.setColor(orange);
        g2.fill(head);
        g2.setColor(outline);
        g2.draw(head);
        
        // Face marking - simple triangle/diamond shape pointing down
        GeneralPath face = new GeneralPath();
        face.moveTo(x, y + 45);           // chin point
        face.lineTo(x - 40, y - 10);      // left cheek
        face.lineTo(x, y - 5);            // top center
        face.lineTo(x + 40, y - 10);      // right cheek
        face.closePath();
        
        g2.setColor(cream);
        g2.fill(face);
        
        // Eyes - simple black ovals
        g2.setColor(black);
        g2.fillOval(x - 25, y - 5, 8, 10);
        g2.fillOval(x + 17, y - 5, 8, 10);
        
        // Nose - small oval
        g2.fillOval(x - 4, y + 18, 8, 6);
        
        // Mouth - simple smile
        g2.setStroke(new BasicStroke(2f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        QuadCurve2D mouth = new QuadCurve2D.Double(x - 6, y + 28, x, y + 33, x + 6, y + 28);
        g2.draw(mouth);
        
        // Reset stroke
        g2.setStroke(new BasicStroke(3f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
    }
    
    void drawFeet(Graphics2D g2, int x, int y) {
        // Front feet - black
        g2.setColor(black);
        
        // Left foot
        Ellipse2D leftFoot = new Ellipse2D.Double(x - 25, y - 10, 22, 25);
        g2.fill(leftFoot);
        
        // Right foot
        Ellipse2D rightFoot = new Ellipse2D.Double(x + 5, y - 10, 22, 25);
        g2.fill(rightFoot);
    }
}
