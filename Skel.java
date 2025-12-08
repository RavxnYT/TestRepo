/*
 * Simple Fox Drawing in Java Graphics2D
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.geom.*;

public class Skel extends JApplet{

    public static void main(String[] args) {
        JFrame frame=new JFrame();
        frame.setTitle("Simple Fox");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JApplet applet =new Skel();
        applet.init();
        frame.getContentPane().add(applet);
        frame.pack();
        frame.setVisible(true);
    }
    
    public void init(){
        JPanel panel=new JApp1Panel();
        getContentPane().add(panel);
    }
}

class JApp1Panel extends JPanel{
    
    // Colors
    Color orange = new Color(226, 113, 41);
    Color cream = new Color(255, 248, 220);
    Color black = Color.BLACK;
    
    public JApp1Panel(){
        setPreferredSize(new Dimension(640, 480));
        setBackground(Color.WHITE);
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        
        // Enable anti-aliasing for smooth edges
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setStroke(new BasicStroke(3f));
        
        int cx = 320; // center x
        int cy = 240; // center y
        
        // === TAIL ===
        GeneralPath tail = new GeneralPath();
        tail.moveTo(cx - 140, cy + 60);
        tail.curveTo(cx - 200, cy - 40, cx - 220, cy - 80, cx - 180, cy - 100);
        tail.curveTo(cx - 140, cy - 120, cx - 100, cy - 60, cx - 100, cy + 20);
        tail.curveTo(cx - 100, cy + 60, cx - 120, cy + 100, cx - 100, cy + 80);
        tail.closePath();
        g2.setColor(orange);
        g2.fill(tail);
        g2.setColor(black);
        g2.draw(tail);
        
        // Tail cream tip
        GeneralPath tailTip = new GeneralPath();
        tailTip.moveTo(cx - 180, cy - 100);
        tailTip.curveTo(cx - 150, cy - 110, cx - 130, cy - 80, cx - 130, cy - 40);
        tailTip.lineTo(cx - 150, cy - 30);
        tailTip.lineTo(cx - 165, cy - 50);
        tailTip.lineTo(cx - 175, cy - 40);
        tailTip.curveTo(cx - 190, cy - 60, cx - 200, cy - 80, cx - 180, cy - 100);
        tailTip.closePath();
        g2.setColor(cream);
        g2.fill(tailTip);
        
        // === BACK LEG ===
        Ellipse2D backLeg = new Ellipse2D.Double(cx - 60, cy + 50, 70, 60);
        g2.setColor(orange);
        g2.fill(backLeg);
        g2.setColor(black);
        g2.draw(backLeg);
        
        // === BODY ===
        Ellipse2D body = new Ellipse2D.Double(cx - 50, cy - 20, 100, 100);
        g2.setColor(orange);
        g2.fill(body);
        g2.setColor(black);
        g2.draw(body);
        
        // Body cream belly
        Ellipse2D belly = new Ellipse2D.Double(cx - 25, cy + 10, 50, 60);
        g2.setColor(cream);
        g2.fill(belly);
        
        // === FRONT PAWS (black) ===
        Ellipse2D leftPaw = new Ellipse2D.Double(cx - 20, cy + 70, 25, 20);
        Ellipse2D rightPaw = new Ellipse2D.Double(cx + 15, cy + 70, 25, 20);
        g2.setColor(black);
        g2.fill(leftPaw);
        g2.fill(rightPaw);
        
        // === HEAD ===
        // Main head shape (rounded triangle-ish)
        GeneralPath head = new GeneralPath();
        head.moveTo(cx, cy - 100); // top of head
        head.curveTo(cx + 80, cy - 80, cx + 90, cy - 20, cx + 70, cy + 20);
        head.curveTo(cx + 50, cy + 50, cx - 50, cy + 50, cx - 70, cy + 20);
        head.curveTo(cx - 90, cy - 20, cx - 80, cy - 80, cx, cy - 100);
        head.closePath();
        g2.setColor(orange);
        g2.fill(head);
        g2.setColor(black);
        g2.draw(head);
        
        // === EARS ===
        // Left ear
        GeneralPath leftEar = new GeneralPath();
        leftEar.moveTo(cx - 55, cy - 60);
        leftEar.lineTo(cx - 75, cy - 120);
        leftEar.lineTo(cx - 30, cy - 75);
        leftEar.closePath();
        g2.setColor(orange);
        g2.fill(leftEar);
        g2.setColor(black);
        g2.draw(leftEar);
        
        // Left ear inner (cream)
        GeneralPath leftEarInner = new GeneralPath();
        leftEarInner.moveTo(cx - 52, cy - 70);
        leftEarInner.lineTo(cx - 65, cy - 105);
        leftEarInner.lineTo(cx - 38, cy - 78);
        leftEarInner.closePath();
        g2.setColor(cream);
        g2.fill(leftEarInner);
        
        // Right ear
        GeneralPath rightEar = new GeneralPath();
        rightEar.moveTo(cx + 55, cy - 60);
        rightEar.lineTo(cx + 75, cy - 120);
        rightEar.lineTo(cx + 30, cy - 75);
        rightEar.closePath();
        g2.setColor(orange);
        g2.fill(rightEar);
        g2.setColor(black);
        g2.draw(rightEar);
        
        // Right ear inner (cream)
        GeneralPath rightEarInner = new GeneralPath();
        rightEarInner.moveTo(cx + 52, cy - 70);
        rightEarInner.lineTo(cx + 65, cy - 105);
        rightEarInner.lineTo(cx + 38, cy - 78);
        rightEarInner.closePath();
        g2.setColor(cream);
        g2.fill(rightEarInner);
        
        // === FACE MARKINGS ===
        // White face (cheeks going down to snout)
        GeneralPath faceCream = new GeneralPath();
        faceCream.moveTo(cx, cy - 50); // between eyes
        faceCream.curveTo(cx - 50, cy - 40, cx - 60, cy, cx - 50, cy + 20);
        faceCream.curveTo(cx - 30, cy + 45, cx + 30, cy + 45, cx + 50, cy + 20);
        faceCream.curveTo(cx + 60, cy, cx + 50, cy - 40, cx, cy - 50);
        faceCream.closePath();
        g2.setColor(cream);
        g2.fill(faceCream);
        
        // Orange eyebrow marks
        GeneralPath leftBrow = new GeneralPath();
        leftBrow.moveTo(cx - 10, cy - 45);
        leftBrow.curveTo(cx - 25, cy - 50, cx - 40, cy - 35, cx - 50, cy - 15);
        leftBrow.curveTo(cx - 40, cy - 25, cx - 25, cy - 35, cx - 10, cy - 45);
        g2.setColor(orange);
        g2.fill(leftBrow);
        g2.setColor(black);
        g2.draw(leftBrow);
        
        GeneralPath rightBrow = new GeneralPath();
        rightBrow.moveTo(cx + 10, cy - 45);
        rightBrow.curveTo(cx + 25, cy - 50, cx + 40, cy - 35, cx + 50, cy - 15);
        rightBrow.curveTo(cx + 40, cy - 25, cx + 25, cy - 35, cx + 10, cy - 45);
        g2.setColor(orange);
        g2.fill(rightBrow);
        g2.setColor(black);
        g2.draw(rightBrow);
        
        // === EYES ===
        Ellipse2D leftEye = new Ellipse2D.Double(cx - 35, cy - 30, 10, 12);
        Ellipse2D rightEye = new Ellipse2D.Double(cx + 25, cy - 30, 10, 12);
        g2.setColor(black);
        g2.fill(leftEye);
        g2.fill(rightEye);
        
        // Eye highlights
        g2.setColor(Color.WHITE);
        g2.fill(new Ellipse2D.Double(cx - 33, cy - 28, 4, 4));
        g2.fill(new Ellipse2D.Double(cx + 27, cy - 28, 4, 4));
        
        // === NOSE ===
        GeneralPath nose = new GeneralPath();
        nose.moveTo(cx, cy - 5);
        nose.lineTo(cx - 8, cy + 8);
        nose.lineTo(cx + 8, cy + 8);
        nose.closePath();
        g2.setColor(black);
        g2.fill(nose);
        
        // === MOUTH ===
        g2.setStroke(new BasicStroke(2f));
        QuadCurve2D leftSmile = new QuadCurve2D.Double(cx, cy + 10, cx - 8, cy + 22, cx - 15, cy + 18);
        QuadCurve2D rightSmile = new QuadCurve2D.Double(cx, cy + 10, cx + 8, cy + 22, cx + 15, cy + 18);
        g2.setColor(black);
        g2.draw(leftSmile);
        g2.draw(rightSmile);
    }
}
