/*
 * Cute Cartoon Fox Drawing
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.geom.*;

public class Skel extends JApplet {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setTitle("Cute Fox");
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
    Color orange = new Color(232, 119, 34);
    Color cream = new Color(255, 248, 231);
    Color black = Color.BLACK;
    
    public JApp1Panel() {
        setPreferredSize(new Dimension(640, 480));
        setBackground(Color.WHITE);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setStroke(new BasicStroke(3));

        int cx = 320; // center x
        int cy = 240; // center y

        // === TAIL ===
        // Tail orange part
        GeneralPath tail = new GeneralPath();
        tail.moveTo(cx - 140, cy + 60);
        tail.curveTo(cx - 200, cy - 20, cx - 220, cy + 40, cx - 180, cy + 120);
        tail.curveTo(cx - 140, cy + 160, cx - 100, cy + 140, cx - 80, cy + 100);
        tail.closePath();
        g2.setColor(orange);
        g2.fill(tail);
        g2.setColor(black);
        g2.draw(tail);

        // Tail cream tip
        GeneralPath tailTip = new GeneralPath();
        tailTip.moveTo(cx - 185, cy + 10);
        tailTip.curveTo(cx - 210, cy + 30, cx - 210, cy + 60, cx - 190, cy + 80);
        tailTip.lineTo(cx - 170, cy + 60);
        tailTip.curveTo(cx - 175, cy + 45, cx - 175, cy + 30, cx - 165, cy + 20);
        tailTip.closePath();
        g2.setColor(cream);
        g2.fill(tailTip);

        // === BACK LEG ===
        Ellipse2D backLeg = new Ellipse2D.Double(cx - 60, cy + 80, 70, 50);
        g2.setColor(orange);
        g2.fill(backLeg);
        g2.setColor(black);
        g2.draw(backLeg);

        // === BODY ===
        Ellipse2D body = new Ellipse2D.Double(cx - 70, cy + 20, 120, 90);
        g2.setColor(orange);
        g2.fill(body);
        g2.setColor(black);
        g2.draw(body);

        // Belly cream
        Ellipse2D belly = new Ellipse2D.Double(cx - 40, cy + 50, 60, 50);
        g2.setColor(cream);
        g2.fill(belly);

        // === FRONT FEET (black) ===
        Ellipse2D footLeft = new Ellipse2D.Double(cx + 10, cy + 100, 30, 20);
        Ellipse2D footRight = new Ellipse2D.Double(cx + 45, cy + 100, 30, 20);
        g2.setColor(black);
        g2.fill(footLeft);
        g2.fill(footRight);

        // === HEAD ===
        // Main head (orange)
        GeneralPath head = new GeneralPath();
        head.moveTo(cx - 10, cy - 60);
        head.curveTo(cx - 80, cy - 50, cx - 90, cy + 30, cx - 20, cy + 50);
        head.lineTo(cx + 40, cy + 50);
        head.curveTo(cx + 110, cy + 30, cx + 100, cy - 50, cx + 30, cy - 60);
        head.closePath();
        g2.setColor(orange);
        g2.fill(head);
        g2.setColor(black);
        g2.draw(head);

        // === EARS ===
        // Left ear (orange)
        int[] leftEarX = {cx - 50, cx - 75, cx - 30};
        int[] leftEarY = {cy - 50, cy - 110, cy - 70};
        Polygon leftEar = new Polygon(leftEarX, leftEarY, 3);
        g2.setColor(orange);
        g2.fill(leftEar);
        g2.setColor(black);
        g2.draw(leftEar);

        // Left ear inner (cream)
        int[] leftEarInX = {cx - 50, cx - 65, cx - 38};
        int[] leftEarInY = {cy - 55, cy - 90, cy - 70};
        Polygon leftEarIn = new Polygon(leftEarInX, leftEarInY, 3);
        g2.setColor(cream);
        g2.fill(leftEarIn);

        // Right ear (orange)
        int[] rightEarX = {cx + 70, cx + 95, cx + 50};
        int[] rightEarY = {cy - 50, cy - 110, cy - 70};
        Polygon rightEar = new Polygon(rightEarX, rightEarY, 3);
        g2.setColor(orange);
        g2.fill(rightEar);
        g2.setColor(black);
        g2.draw(rightEar);

        // Right ear inner (cream)
        int[] rightEarInX = {cx + 70, cx + 85, cx + 55};
        int[] rightEarInY = {cy - 55, cy - 90, cy - 70};
        Polygon rightEarIn = new Polygon(rightEarInX, rightEarInY, 3);
        g2.setColor(cream);
        g2.fill(rightEarIn);

        // === FACE MARKINGS ===
        // Face cream area (cheeks and snout)
        GeneralPath faceCream = new GeneralPath();
        faceCream.moveTo(cx - 60, cy - 20);
        faceCream.curveTo(cx - 70, cy + 10, cx - 40, cy + 50, cx + 10, cy + 45);
        faceCream.curveTo(cx + 60, cy + 50, cx + 90, cy + 10, cx + 80, cy - 20);
        faceCream.curveTo(cx + 60, cy - 10, cx + 30, cy + 10, cx + 10, cy + 5);
        faceCream.curveTo(cx - 10, cy + 10, cx - 40, cy - 10, cx - 60, cy - 20);
        faceCream.closePath();
        g2.setColor(cream);
        g2.fill(faceCream);

        // === EYES ===
        // Left eye
        Ellipse2D leftEye = new Ellipse2D.Double(cx - 30, cy - 20, 12, 14);
        g2.setColor(black);
        g2.fill(leftEye);
        // Eye shine
        Ellipse2D leftShine = new Ellipse2D.Double(cx - 28, cy - 18, 4, 4);
        g2.setColor(Color.WHITE);
        g2.fill(leftShine);

        // Right eye
        Ellipse2D rightEye = new Ellipse2D.Double(cx + 38, cy - 20, 12, 14);
        g2.setColor(black);
        g2.fill(rightEye);
        // Eye shine
        Ellipse2D rightShine = new Ellipse2D.Double(cx + 40, cy - 18, 4, 4);
        g2.setColor(Color.WHITE);
        g2.fill(rightShine);

        // === NOSE ===
        int[] noseX = {cx + 10, cx + 5, cx + 15};
        int[] noseY = {cy + 5, cy + 15, cy + 15};
        Polygon nose = new Polygon(noseX, noseY, 3);
        g2.setColor(black);
        g2.fill(nose);

        // === MOUTH ===
        g2.setStroke(new BasicStroke(2));
        QuadCurve2D mouthLeft = new QuadCurve2D.Double(cx + 10, cy + 15, cx, cy + 28, cx - 5, cy + 22);
        QuadCurve2D mouthRight = new QuadCurve2D.Double(cx + 10, cy + 15, cx + 20, cy + 28, cx + 25, cy + 22);
        g2.draw(mouthLeft);
        g2.draw(mouthRight);

        // === EYEBROWS (subtle curves) ===
        g2.setStroke(new BasicStroke(2));
        QuadCurve2D leftBrow = new QuadCurve2D.Double(cx - 35, cy - 30, cx - 22, cy - 38, cx - 15, cy - 32);
        QuadCurve2D rightBrow = new QuadCurve2D.Double(cx + 35, cy - 32, cx + 45, cy - 38, cx + 55, cy - 30);
        g2.setColor(orange);
        g2.draw(leftBrow);
        g2.draw(rightBrow);
    }
}
