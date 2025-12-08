import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Path2D;
import java.awt.geom.QuadCurve2D;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Skel extends JApplet {

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

    @Override
    public void init() {
        JPanel panel = new JApp1Panel();
        getContentPane().add(panel);
    }
}

class JApp1Panel extends JPanel {
    private static final Color OUTLINE = new Color(25, 20, 20);
    private static final Color FUR = new Color(237, 129, 33);
    private static final Color CREAM = new Color(253, 240, 212);
    private static final Color PAWS = new Color(32, 32, 32);

    public JApp1Panel() {
        setPreferredSize(new Dimension(640, 480));
        setBackground(new Color(252, 252, 252));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        AffineTransform original = g2.getTransform();
        g2.translate(180, 80);
        g2.scale(1.2, 1.2);
        g2.setStroke(new BasicStroke(6f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        drawFox(g2);
        g2.setTransform(original);
        g2.dispose();
    }

    private void drawFox(Graphics2D g2) {
        Path2D.Double tail = new Path2D.Double();
        tail.moveTo(-110, 160);
        tail.curveTo(-160, 80, -110, 20, -30, 50);
        tail.curveTo(20, 80, 10, 160, -60, 190);
        tail.closePath();
        fillAndOutline(g2, tail, FUR);

        Path2D.Double tailTip = new Path2D.Double();
        tailTip.moveTo(-85, 130);
        tailTip.curveTo(-105, 95, -75, 60, -35, 85);
        tailTip.curveTo(-20, 100, -40, 145, -70, 155);
        tailTip.closePath();
        fillAndOutline(g2, tailTip, CREAM);

        RoundRectangle2D.Double body = new RoundRectangle2D.Double(-5, 110, 170, 170, 140, 140);
        fillAndOutline(g2, body, FUR);

        Path2D.Double chest = new Path2D.Double();
        chest.moveTo(45, 130);
        chest.curveTo(25, 170, 40, 220, 95, 250);
        chest.curveTo(115, 220, 110, 165, 115, 135);
        chest.curveTo(90, 150, 70, 150, 45, 130);
        chest.closePath();
        fillAndOutline(g2, chest, CREAM);

        RoundRectangle2D.Double backLeg = new RoundRectangle2D.Double(35, 230, 65, 80, 60, 60);
        fillAndOutline(g2, backLeg, FUR);

        RoundRectangle2D.Double frontLeg = new RoundRectangle2D.Double(105, 220, 55, 95, 50, 50);
        fillAndOutline(g2, frontLeg, FUR);

        RoundRectangle2D.Double backPaw = new RoundRectangle2D.Double(40, 280, 60, 35, 30, 30);
        fillAndOutline(g2, backPaw, PAWS);

        RoundRectangle2D.Double frontPaw = new RoundRectangle2D.Double(110, 280, 60, 35, 30, 30);
        fillAndOutline(g2, frontPaw, PAWS);

        Path2D.Double head = new Path2D.Double();
        head.moveTo(30, 70);
        head.curveTo(-5, 25, 65, -25, 135, 10);
        head.curveTo(200, -20, 240, 40, 215, 90);
        head.curveTo(190, 130, 80, 135, 30, 70);
        head.closePath();
        fillAndOutline(g2, head, FUR);

        Path2D.Double face = new Path2D.Double();
        face.moveTo(70, 90);
        face.curveTo(50, 60, 90, 35, 120, 55);
        face.curveTo(150, 35, 190, 60, 170, 90);
        face.curveTo(160, 110, 80, 115, 70, 90);
        face.closePath();
        fillAndOutline(g2, face, CREAM);

        Path2D.Double earLeft = new Path2D.Double();
        earLeft.moveTo(30, 70);
        earLeft.curveTo(5, 25, 30, -5, 70, 20);
        earLeft.curveTo(60, 45, 55, 60, 30, 70);
        earLeft.closePath();
        fillAndOutline(g2, earLeft, FUR);

        Path2D.Double earLeftInner = new Path2D.Double();
        earLeftInner.moveTo(35, 65);
        earLeftInner.curveTo(20, 30, 40, 10, 60, 25);
        earLeftInner.curveTo(55, 40, 50, 55, 35, 65);
        earLeftInner.closePath();
        fillAndOutline(g2, earLeftInner, CREAM);

        Path2D.Double earRight = new Path2D.Double();
        earRight.moveTo(210, 85);
        earRight.curveTo(220, 35, 205, 0, 165, 25);
        earRight.curveTo(175, 55, 185, 70, 210, 85);
        earRight.closePath();
        fillAndOutline(g2, earRight, FUR);

        Path2D.Double earRightInner = new Path2D.Double();
        earRightInner.moveTo(200, 80);
        earRightInner.curveTo(208, 40, 198, 15, 175, 35);
        earRightInner.curveTo(182, 55, 188, 70, 200, 80);
        earRightInner.closePath();
        fillAndOutline(g2, earRightInner, CREAM);

        Ellipse2D.Double leftEye = new Ellipse2D.Double(95, 95, 12, 16);
        Ellipse2D.Double rightEye = new Ellipse2D.Double(150, 95, 12, 16);
        fillAndOutline(g2, leftEye, PAWS);
        fillAndOutline(g2, rightEye, PAWS);

        RoundRectangle2D.Double nose = new RoundRectangle2D.Double(125, 115, 18, 12, 8, 8);
        fillAndOutline(g2, nose, PAWS);

        QuadCurve2D.Double smile = new QuadCurve2D.Double(110, 135, 134, 148, 158, 135);
        g2.setColor(PAWS);
        g2.draw(smile);
    }

    private void fillAndOutline(Graphics2D g2, java.awt.Shape shape, Color fill) {
        g2.setColor(fill);
        g2.fill(shape);
        g2.setColor(OUTLINE);
        g2.draw(shape);
    }
}
