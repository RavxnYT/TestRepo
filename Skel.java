/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.geom.*;

public class Skel extends JApplet {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setTitle("hello");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JApplet applete = new Skel();
        applete.init();
        frame.getContentPane().add(applete);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    @Override
    public void init() {
        JPanel panel = new JApp1Panel();
        getContentPane().add(panel);
    }
}

class JApp1Panel extends JPanel {

    public JApp1Panel() {
        setPreferredSize(new Dimension(640, 480));
        setBackground(new Color(250, 248, 239));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        paintBackdrop(g2);
        drawFox(g2);
        g2.dispose();
    }

    private void paintBackdrop(Graphics2D g2) {
        g2.setColor(getBackground());
        g2.fillRect(0, 0, getWidth(), getHeight());

        g2.setColor(new Color(232, 226, 212));
        int groundHeight = 90;
        g2.fillRoundRect(40, getHeight() - groundHeight, getWidth() - 80, groundHeight - 10, 45, 45);
    }

    private void drawFox(Graphics2D g2) {
        Color orange = new Color(240, 135, 24);
        Color cream = new Color(255, 247, 228);
        Color dark = new Color(37, 30, 28);

        AffineTransform saved = g2.getTransform();
        g2.translate(getWidth() / 2.0, getHeight() / 2.0 + 25);
        g2.scale(1.2, 1.2);

        BasicStroke outline = new BasicStroke(6f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
        g2.setStroke(outline);

        // Tail
        Path2D tail = new Path2D.Double();
        tail.moveTo(60, 70);
        tail.curveTo(160, 50, 205, -30, 150, -115);
        tail.curveTo(115, -170, 35, -140, 35, -60);
        tail.curveTo(30, -10, 45, 30, 28, 105);
        tail.curveTo(42, 135, 55, 110, 60, 70);
        tail.closePath();
        g2.setColor(orange);
        g2.fill(tail);
        g2.setColor(dark);
        g2.draw(tail);

        Path2D tailTip = new Path2D.Double();
        tailTip.moveTo(120, -15);
        tailTip.curveTo(150, -55, 162, -10, 140, 40);
        tailTip.curveTo(115, 65, 90, 45, 95, 5);
        tailTip.closePath();
        g2.setColor(cream);
        g2.fill(tailTip);
        g2.setColor(dark);
        g2.draw(tailTip);

        // Body
        RoundRectangle2D body = new RoundRectangle2D.Double(-80, -15, 150, 190, 130, 130);
        g2.setColor(orange);
        g2.fill(body);
        g2.setColor(dark);
        g2.draw(body);

        Path2D belly = new Path2D.Double();
        belly.moveTo(-25, 0);
        belly.curveTo(-60, 80, -35, 165, -5, 155);
        belly.curveTo(28, 155, 50, 70, 16, -5);
        belly.curveTo(5, -20, -15, -15, -25, 0);
        belly.closePath();
        g2.setColor(cream);
        g2.fill(belly);

        Shape backLeg = new RoundRectangle2D.Double(15, 95, 50, 80, 40, 40);
        Shape frontLeg = new RoundRectangle2D.Double(-35, 95, 40, 90, 40, 40);
        g2.setColor(dark);
        g2.fill(backLeg);
        g2.fill(frontLeg);

        // Head and ears
        Path2D earLeft = new Path2D.Double();
        earLeft.moveTo(-80, -150);
        earLeft.lineTo(-140, -225);
        earLeft.lineTo(-40, -195);
        earLeft.closePath();
        g2.setColor(orange);
        g2.fill(earLeft);
        g2.setColor(dark);
        g2.draw(earLeft);

        Path2D earRight = new Path2D.Double();
        earRight.moveTo(80, -150);
        earRight.lineTo(140, -225);
        earRight.lineTo(40, -195);
        earRight.closePath();
        g2.setColor(orange);
        g2.fill(earRight);
        g2.setColor(dark);
        g2.draw(earRight);

        Path2D head = new Path2D.Double();
        head.moveTo(-115, -120);
        head.curveTo(-165, -35, -130, 30, 0, 65);
        head.curveTo(130, 30, 165, -35, 115, -120);
        head.curveTo(65, -175, -65, -175, -115, -120);
        head.closePath();
        g2.setColor(orange);
        g2.fill(head);
        g2.setColor(dark);
        g2.draw(head);

        Path2D face = new Path2D.Double();
        face.moveTo(-88, -85);
        face.curveTo(-82, -20, -45, 40, 0, 40);
        face.curveTo(45, 40, 82, -20, 88, -85);
        face.curveTo(58, -120, -58, -120, -88, -85);
        face.closePath();
        g2.setColor(cream);
        g2.fill(face);
        g2.setColor(dark);
        g2.draw(face);

        Path2D innerLeft = new Path2D.Double();
        innerLeft.moveTo(-85, -160);
        innerLeft.lineTo(-124, -212);
        innerLeft.lineTo(-55, -190);
        innerLeft.closePath();
        g2.setColor(cream);
        g2.fill(innerLeft);

        Path2D innerRight = new Path2D.Double();
        innerRight.moveTo(85, -160);
        innerRight.lineTo(124, -212);
        innerRight.lineTo(55, -190);
        innerRight.closePath();
        g2.fill(innerRight);

        // Eyes & nose
        g2.setColor(dark);
        g2.fill(new Ellipse2D.Double(-40, -35, 16, 22));
        g2.fill(new Ellipse2D.Double(24, -35, 16, 22));

        Path2D nose = new Path2D.Double();
        nose.moveTo(-8, -8);
        nose.lineTo(0, 0);
        nose.lineTo(8, -8);
        nose.curveTo(2, 2, -2, 2, -8, -8);
        nose.closePath();
        g2.fill(nose);

        BasicStroke smileStroke = new BasicStroke(3.5f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
        g2.setStroke(smileStroke);
        g2.draw(new QuadCurve2D.Double(-5, 5, -2, 15, -16, 18));
        g2.draw(new QuadCurve2D.Double(5, 5, 2, 15, 16, 18));

        // Paw details
        g2.setStroke(new BasicStroke(2.5f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        g2.drawLine(-25, 170, -10, 170);
        g2.drawLine(20, 165, 40, 165);

        g2.setTransform(saved);
    }
}
