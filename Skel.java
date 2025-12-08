/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Path2D;
import java.awt.geom.QuadCurve2D;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author eid.emary
 */
public class Skel extends JApplet {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setTitle("hello");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JApplet applete = new Skel();
        applete.init();
        frame.getContentPane().add(applete);
        frame.pack();
        frame.setVisible(true);
    }

    public void init() {
        JPanel panel = new JApp1Panel();
        getContentPane().add(panel);
    }

}

class JApp1Panel extends JPanel {

    public JApp1Panel() {
        setPreferredSize(new Dimension(640, 480));
        setBackground(Color.WHITE);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        drawFox(g2);
        g2.dispose();
    }

    private void drawFox(Graphics2D g2) {
        final double canvas = 320.0;
        double scale = Math.min(getWidth(), getHeight()) / canvas;
        double offsetX = (getWidth() - canvas * scale) / 2.0;
        double offsetY = (getHeight() - canvas * scale) / 2.0;

        g2.translate(offsetX, offsetY);
        g2.scale(scale, scale);

        Color foxOrange = new Color(248, 137, 42);
        Color foxCream = new Color(253, 242, 214);
        Color foxDark = new Color(35, 28, 32);

        Shape body = new RoundRectangle2D.Double(110, 150, 150, 110, 120, 120);
        Shape rump = new RoundRectangle2D.Double(80, 170, 80, 90, 90, 90);

        Path2D.Double tail = new Path2D.Double();
        tail.moveTo(215, 185);
        tail.curveTo(300, 150, 305, 255, 245, 270);
        tail.curveTo(245, 245, 220, 225, 215, 205);
        tail.closePath();

        Path2D.Double tailTip = new Path2D.Double();
        tailTip.moveTo(255, 205);
        tailTip.curveTo(280, 215, 275, 250, 250, 252);
        tailTip.curveTo(248, 235, 245, 220, 255, 205);
        tailTip.closePath();

        Shape head = new RoundRectangle2D.Double(95, 70, 150, 110, 120, 120);

        Path2D.Double face = new Path2D.Double();
        face.moveTo(108, 115);
        face.curveTo(150, 165, 190, 165, 232, 115);
        face.curveTo(200, 155, 150, 155, 108, 115);
        face.closePath();

        Path2D.Double chest = new Path2D.Double();
        chest.moveTo(155, 170);
        chest.curveTo(135, 215, 160, 250, 190, 255);
        chest.curveTo(195, 225, 205, 205, 210, 170);
        chest.closePath();

        Path2D.Double earLeft = new Path2D.Double();
        earLeft.moveTo(120, 80);
        earLeft.lineTo(140, 35);
        earLeft.lineTo(160, 90);
        earLeft.closePath();

        Path2D.Double earRight = new Path2D.Double();
        earRight.moveTo(190, 90);
        earRight.lineTo(210, 35);
        earRight.lineTo(230, 85);
        earRight.closePath();

        Path2D.Double earLeftInner = new Path2D.Double();
        earLeftInner.moveTo(131, 82);
        earLeftInner.lineTo(141, 50);
        earLeftInner.lineTo(152, 86);
        earLeftInner.closePath();

        Path2D.Double earRightInner = new Path2D.Double();
        earRightInner.moveTo(201, 88);
        earRightInner.lineTo(212, 52);
        earRightInner.lineTo(222, 84);
        earRightInner.closePath();

        Shape pawFront = new RoundRectangle2D.Double(150, 235, 32, 38, 30, 30);
        Shape pawRear = new RoundRectangle2D.Double(200, 240, 40, 32, 30, 30);

        Shape eyeLeft = new Ellipse2D.Double(140, 120, 10, 14);
        Shape eyeRight = new Ellipse2D.Double(190, 120, 10, 14);
        Shape nose = new RoundRectangle2D.Double(167, 138, 14, 10, 8, 8);

        g2.setColor(foxOrange);
        g2.fill(tail);
        g2.fill(body);
        g2.fill(rump);
        g2.fill(head);
        g2.fill(earLeft);
        g2.fill(earRight);

        g2.setColor(foxCream);
        g2.fill(face);
        g2.fill(chest);
        g2.fill(earLeftInner);
        g2.fill(earRightInner);
        g2.fill(tailTip);

        g2.setColor(foxDark);
        g2.fill(pawFront);
        g2.fill(pawRear);
        g2.fill(eyeLeft);
        g2.fill(eyeRight);
        g2.fill(nose);

        g2.setStroke(new BasicStroke(6f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        g2.setColor(foxDark);
        Shape[] outlines = new Shape[]{tail, body, rump, head, earLeft, earRight, pawFront, pawRear};
        for (Shape outline : outlines) {
            g2.draw(outline);
        }

        g2.setStroke(new BasicStroke(3f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        g2.draw(new Line2D.Double(174, 142, 174, 150));
        g2.draw(new QuadCurve2D.Double(165, 150, 174, 157, 182, 150));
    }
}
