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
    Color orange = new Color(227, 119, 47);
    Color cream = new Color(255, 248, 225);
    Color black = Color.BLACK;
    
    public JApp1Panel(){
        setPreferredSize(new Dimension(640, 480));
        setBackground(Color.WHITE);
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        
        // Enable antialiasing for smooth edges
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setStroke(new BasicStroke(3f));
        
        int cx = 320; // center x
        int cy = 240; // center y
        
        // === TAIL ===
        GeneralPath tail = new GeneralPath();
        tail.moveTo(cx - 120, cy + 60);
        tail.curveTo(cx - 200, cy - 20, cx - 200, cy - 100, cx - 140, cy - 80);
        tail.lineTo(cx - 150, cy - 60);
        tail.lineTo(cx - 130, cy - 70);
        tail.lineTo(cx - 140, cy - 50);
        tail.curveTo(cx - 160, cy - 40, cx - 160, cy + 40, cx - 100, cy + 80);
        tail.closePath();
        g2.setColor(orange);
        g2.fill(tail);
        g2.setColor(black);
        g2.draw(tail);
        
        // Tail cream tip
        GeneralPath tailTip = new GeneralPath();
        tailTip.moveTo(cx - 140, cy - 80);
        tailTip.curveTo(cx - 170, cy - 100, cx - 190, cy - 60, cx - 150, cy - 60);
        tailTip.lineTo(cx - 130, cy - 70);
        tailTip.lineTo(cx - 140, cy - 50);
        tailTip.curveTo(cx - 155, cy - 55, cx - 155, cy - 70, cx - 140, cy - 80);
        g2.setColor(cream);
        g2.fill(tailTip);
        
        // === BACK LEG ===
        Ellipse2D backLeg = new Ellipse2D.Double(cx - 60, cy + 70, 70, 50);
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
        
        // === FRONT FEET ===
        Ellipse2D frontFoot1 = new Ellipse2D.Double(cx - 10, cy + 85, 25, 20);
        Ellipse2D frontFoot2 = new Ellipse2D.Double(cx + 20, cy + 85, 25, 20);
        g2.setColor(black);
        g2.fill(frontFoot1);
        g2.fill(frontFoot2);
        
        // === HEAD ===
        // Main head shape (rounded triangle pointing down)
        GeneralPath head = new GeneralPath();
        head.moveTo(cx, cy - 100);  // top center
        head.curveTo(cx + 80, cy - 100, cx + 90, cy - 40, cx + 70, cy - 20);
        head.lineTo(cx, cy + 30);   // chin
        head.lineTo(cx - 70, cy - 20);
        head.curveTo(cx - 90, cy - 40, cx - 80, cy - 100, cx, cy - 100);
        head.closePath();
        g2.setColor(orange);
        g2.fill(head);
        g2.setColor(black);
        g2.draw(head);
        
        // Face cream marking (inner face)
        GeneralPath faceMark = new GeneralPath();
        faceMark.moveTo(cx, cy - 70);
        faceMark.curveTo(cx + 50, cy - 60, cx + 50, cy - 20, cx + 35, cy - 10);
        faceMark.lineTo(cx, cy + 25);
        faceMark.lineTo(cx - 35, cy - 10);
        faceMark.curveTo(cx - 50, cy - 20, cx - 50, cy - 60, cx, cy - 70);
        faceMark.closePath();
        g2.setColor(cream);
        g2.fill(faceMark);
        
        // === EARS ===
        // Left ear
        GeneralPath leftEar = new GeneralPath();
        leftEar.moveTo(cx - 55, cy - 80);
        leftEar.lineTo(cx - 70, cy - 140);
        leftEar.lineTo(cx - 25, cy - 90);
        leftEar.closePath();
        g2.setColor(orange);
        g2.fill(leftEar);
        g2.setColor(black);
        g2.draw(leftEar);
        
        // Left ear inner
        GeneralPath leftEarInner = new GeneralPath();
        leftEarInner.moveTo(cx - 52, cy - 90);
        leftEarInner.lineTo(cx - 62, cy - 120);
        leftEarInner.lineTo(cx - 38, cy - 95);
        leftEarInner.closePath();
        g2.setColor(cream);
        g2.fill(leftEarInner);
        
        // Right ear
        GeneralPath rightEar = new GeneralPath();
        rightEar.moveTo(cx + 55, cy - 80);
        rightEar.lineTo(cx + 70, cy - 140);
        rightEar.lineTo(cx + 25, cy - 90);
        rightEar.closePath();
        g2.setColor(orange);
        g2.fill(rightEar);
        g2.setColor(black);
        g2.draw(rightEar);
        
        // Right ear inner
        GeneralPath rightEarInner = new GeneralPath();
        rightEarInner.moveTo(cx + 52, cy - 90);
        rightEarInner.lineTo(cx + 62, cy - 120);
        rightEarInner.lineTo(cx + 38, cy - 95);
        rightEarInner.closePath();
        g2.setColor(cream);
        g2.fill(rightEarInner);
        
        // === FACE DETAILS ===
        // Eyes
        g2.setColor(black);
        g2.fillOval(cx - 30, cy - 45, 10, 12);
        g2.fillOval(cx + 20, cy - 45, 10, 12);
        
        // Nose
        GeneralPath nose = new GeneralPath();
        nose.moveTo(cx, cy - 20);
        nose.lineTo(cx - 6, cy - 28);
        nose.lineTo(cx + 6, cy - 28);
        nose.closePath();
        g2.fill(nose);
        
        // Mouth
        g2.setStroke(new BasicStroke(2f));
        QuadCurve2D smile = new QuadCurve2D.Double(cx - 12, cy - 12, cx, cy - 2, cx + 12, cy - 12);
        g2.draw(smile);
        
        // Eyebrow accents (orange curves above eyes)
        g2.setColor(orange);
        g2.setStroke(new BasicStroke(3f));
        QuadCurve2D leftBrow = new QuadCurve2D.Double(cx - 45, cy - 55, cx - 30, cy - 65, cx - 15, cy - 55);
        QuadCurve2D rightBrow = new QuadCurve2D.Double(cx + 15, cy - 55, cx + 30, cy - 65, cx + 45, cy - 55);
        g2.draw(leftBrow);
        g2.draw(rightBrow);
    }
}
