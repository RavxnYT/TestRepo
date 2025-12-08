/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.geom.*;

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
    private static final Color FOX_ORANGE = new Color(0xF07B1D);
    private static final Color FOX_LIGHT = new Color(0xFDE6CC);
    private static final Color FOX_DARK = new Color(0x1F1B1B);
    private static final Color FOX_ACCENT = new Color(0xFFB55B);
    private static final Color BACKGROUND = new Color(0xFFFDF4);

    public JApp1Panel(){
        setPreferredSize(new Dimension(640,480));
        setBackground(BACKGROUND);
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2=(Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setColor(BACKGROUND);
        g2.fillRect(0, 0, getWidth(), getHeight());

        double designSize = 360.0;
        double scale = Math.min(getWidth(), getHeight()) / designSize;
        double offsetX = (getWidth() - designSize * scale) / 2.0;
        double offsetY = (getHeight() - designSize * scale) / 2.0;
        g2.translate(offsetX, offsetY);
        g2.scale(scale, scale);

        float strokeWidth = (float) (6f / scale);

        Path2D tail = new Path2D.Double();
        tail.moveTo(60, 210);
        tail.curveTo(10, 150, 35, 70, 110, 90);
        tail.curveTo(150, 180, 140, 260, 90, 300);
        tail.curveTo(40, 300, 30, 260, 60, 210);
        tail.closePath();

        Path2D tailTip = new Path2D.Double();
        tailTip.moveTo(65, 215);
        tailTip.curveTo(45, 240, 55, 270, 85, 280);
        tailTip.curveTo(115, 260, 115, 220, 110, 205);
        tailTip.curveTo(90, 210, 80, 212, 65, 215);
        tailTip.closePath();

        Path2D body = new Path2D.Double();
        body.moveTo(140, 150);
        body.curveTo(120, 200, 130, 270, 190, 300);
        body.curveTo(250, 320, 310, 280, 310, 220);
        body.curveTo(315, 170, 280, 140, 250, 140);
        body.curveTo(210, 130, 170, 130, 140, 150);
        body.closePath();

        Path2D chest = new Path2D.Double();
        chest.moveTo(185, 170);
        chest.curveTo(165, 210, 175, 265, 210, 290);
        chest.curveTo(235, 270, 240, 215, 220, 170);
        chest.closePath();

        Path2D head = new Path2D.Double();
        head.moveTo(175, 115);
        head.curveTo(180, 70, 215, 45, 250, 65);
        head.curveTo(295, 45, 335, 95, 330, 145);
        head.curveTo(325, 200, 285, 215, 250, 212);
        head.curveTo(220, 215, 185, 205, 160, 188);
        head.curveTo(140, 170, 135, 130, 150, 110);
        head.curveTo(160, 100, 170, 100, 175, 115);
        head.closePath();

        Path2D faceMask = new Path2D.Double();
        faceMask.moveTo(170, 165);
        faceMask.curveTo(190, 150, 210, 155, 220, 170);
        faceMask.curveTo(230, 155, 250, 150, 270, 165);
        faceMask.curveTo(260, 195, 230, 210, 220, 210);
        faceMask.curveTo(205, 210, 180, 200, 170, 165);
        faceMask.closePath();

        Path2D leftEar = new Path2D.Double();
        leftEar.moveTo(190, 80);
        leftEar.lineTo(160, 25);
        leftEar.lineTo(145, 95);
        leftEar.closePath();

        Path2D rightEar = new Path2D.Double();
        rightEar.moveTo(285, 75);
        rightEar.lineTo(315, 25);
        rightEar.lineTo(325, 105);
        rightEar.closePath();

        Path2D leftEarInner = new Path2D.Double();
        leftEarInner.moveTo(185, 80);
        leftEarInner.lineTo(165, 45);
        leftEarInner.lineTo(155, 95);
        leftEarInner.closePath();

        Path2D rightEarInner = new Path2D.Double();
        rightEarInner.moveTo(290, 80);
        rightEarInner.lineTo(307, 45);
        rightEarInner.lineTo(315, 105);
        rightEarInner.closePath();

        Shape frontPawLeft = new RoundRectangle2D.Double(170, 280, 40, 45, 20, 20);
        Shape frontPawRight = new RoundRectangle2D.Double(220, 280, 40, 45, 20, 20);

        g2.setColor(FOX_ORANGE);
        g2.fill(tail);
        g2.fill(body);
        g2.fill(head);
        g2.fill(leftEar);
        g2.fill(rightEar);

        g2.setColor(FOX_ACCENT);
        g2.fill(frontPawLeft);
        g2.fill(frontPawRight);

        g2.setColor(FOX_LIGHT);
        g2.fill(tailTip);
        g2.fill(chest);
        g2.fill(faceMask);
        g2.fill(leftEarInner);
        g2.fill(rightEarInner);

        Ellipse2D eyeLeft = new Ellipse2D.Double(195, 175, 12, 16);
        Ellipse2D eyeRight = new Ellipse2D.Double(245, 175, 12, 16);
        Ellipse2D nose = new Ellipse2D.Double(220, 195, 14, 10);

        g2.setColor(FOX_DARK);
        g2.fill(eyeLeft);
        g2.fill(eyeRight);
        g2.fill(nose);

        Path2D smile = new Path2D.Double();
        smile.moveTo(227, 205);
        smile.quadTo(227, 215, 217, 215);
        smile.moveTo(227, 205);
        smile.quadTo(227, 215, 237, 215);
        g2.setStroke(new BasicStroke((float) (4f / scale), BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        g2.draw(smile);

        g2.setStroke(new BasicStroke(strokeWidth, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        g2.draw(tail);
        g2.draw(body);
        g2.draw(head);
        g2.draw(leftEar);
        g2.draw(rightEar);
        g2.draw(frontPawLeft);
        g2.draw(frontPawRight);

        g2.dispose();
        
    }
}