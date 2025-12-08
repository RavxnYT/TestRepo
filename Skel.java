import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Path2D;
import java.awt.geom.QuadCurve2D;
import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Skel extends JApplet {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("hello");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JApplet applet = new Skel();
            applet.init();
            applet.start();

            frame.getContentPane().add(applet);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }

    @Override
    public void init() {
        JPanel panel = new JApp1Panel();
        getContentPane().add(panel);
    }
}

class JApp1Panel extends JPanel {

    private static final Color FOX_ORANGE = new Color(246, 140, 35);
    private static final Color FOX_WHITE = new Color(250, 250, 250);
    private static final Color FOX_DARK = new Color(25, 25, 25);
    private static final Color FOX_PINK = new Color(255, 205, 180);
    private static final BasicStroke OUTLINE =
            new BasicStroke(4f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
    private static final BasicStroke DETAIL =
            new BasicStroke(2.2f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);

    public JApp1Panel() {
        setPreferredSize(new Dimension(640, 480));
        setBackground(Color.WHITE);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        double targetWidth = 320.0;
        double targetHeight = 360.0;
        double scale = Math.min(getWidth() / targetWidth, getHeight() / targetHeight);
        double translateX = (getWidth() - targetWidth * scale) / 2.0;
        double translateY = (getHeight() - targetHeight * scale) / 2.0;

        g2.translate(translateX, translateY);
        g2.scale(scale, scale);

        paintFox(g2);
        g2.dispose();
    }

    private void paintFox(Graphics2D g2) {
        g2.setStroke(OUTLINE);

        Path2D.Double tail = new Path2D.Double();
        tail.moveTo(165, 178);
        tail.curveTo(120, 135, 70, 120, 55, 165);
        tail.curveTo(40, 220, 80, 260, 135, 250);
        tail.curveTo(190, 240, 210, 205, 200, 180);
        tail.curveTo(193, 165, 175, 165, 165, 178);
        tail.closePath();
        fillAndOutline(g2, tail, FOX_ORANGE);

        Path2D.Double tailTip = new Path2D.Double();
        tailTip.moveTo(90, 162);
        tailTip.curveTo(70, 190, 85, 225, 115, 232);
        tailTip.curveTo(140, 236, 158, 215, 162, 195);
        tailTip.curveTo(150, 178, 125, 168, 105, 164);
        tailTip.closePath();
        fillAndOutline(g2, tailTip, FOX_WHITE);

        Path2D.Double body = new Path2D.Double();
        body.moveTo(205, 120);
        body.curveTo(245, 140, 270, 190, 265, 235);
        body.curveTo(260, 285, 230, 315, 205, 330);
        body.curveTo(170, 340, 140, 320, 135, 275);
        body.curveTo(130, 230, 140, 180, 165, 150);
        body.curveTo(180, 130, 195, 118, 205, 120);
        body.closePath();
        fillAndOutline(g2, body, FOX_ORANGE);

        Path2D.Double chest = new Path2D.Double();
        chest.moveTo(195, 125);
        chest.curveTo(170, 145, 160, 175, 160, 215);
        chest.curveTo(160, 260, 175, 305, 200, 320);
        chest.curveTo(220, 305, 235, 270, 230, 215);
        chest.curveTo(225, 175, 210, 145, 195, 125);
        chest.closePath();
        fillAndOutline(g2, chest, FOX_WHITE);

        Path2D.Double leftLeg = new Path2D.Double();
        leftLeg.moveTo(165, 225);
        leftLeg.curveTo(150, 260, 145, 300, 152, 335);
        leftLeg.lineTo(188, 335);
        leftLeg.curveTo(178, 300, 178, 260, 185, 225);
        leftLeg.closePath();
        fillAndOutline(g2, leftLeg, FOX_DARK);

        Path2D.Double rightLeg = new Path2D.Double();
        rightLeg.moveTo(212, 235);
        rightLeg.curveTo(205, 270, 205, 305, 214, 335);
        rightLeg.lineTo(252, 335);
        rightLeg.curveTo(242, 295, 240, 260, 246, 230);
        rightLeg.closePath();
        fillAndOutline(g2, rightLeg, FOX_DARK);

        Path2D.Double head = new Path2D.Double();
        head.moveTo(195, 85);
        head.lineTo(175, 30);
        head.curveTo(165, 10, 145, 15, 140, 40);
        head.lineTo(135, 95);
        head.curveTo(128, 135, 140, 165, 155, 178);
        head.lineTo(235, 178);
        head.curveTo(250, 160, 258, 130, 250, 95);
        head.lineTo(245, 38);
        head.curveTo(240, 12, 220, 10, 210, 30);
        head.closePath();
        fillAndOutline(g2, head, FOX_ORANGE);

        Path2D.Double face = new Path2D.Double();
        face.moveTo(175, 95);
        face.curveTo(150, 120, 142, 150, 160, 180);
        face.curveTo(175, 200, 215, 200, 230, 180);
        face.curveTo(245, 150, 235, 120, 210, 95);
        face.curveTo(200, 90, 185, 90, 175, 95);
        face.closePath();
        fillAndOutline(g2, face, FOX_WHITE);

        Path2D.Double leftInnerEar = new Path2D.Double();
        leftInnerEar.moveTo(174, 38);
        leftInnerEar.lineTo(158, 74);
        leftInnerEar.lineTo(182, 78);
        leftInnerEar.closePath();
        fillShape(g2, leftInnerEar, FOX_PINK);

        Path2D.Double rightInnerEar = new Path2D.Double();
        rightInnerEar.moveTo(218, 32);
        rightInnerEar.lineTo(236, 74);
        rightInnerEar.lineTo(212, 78);
        rightInnerEar.closePath();
        fillShape(g2, rightInnerEar, FOX_PINK);

        g2.setStroke(DETAIL);
        g2.setColor(Color.BLACK);
        g2.draw(new QuadCurve2D.Double(175, 150, 185, 165, 183, 178));
        g2.draw(new QuadCurve2D.Double(230, 150, 220, 165, 222, 178));

        Ellipse2D.Double leftEye = new Ellipse2D.Double(182, 142, 6, 10);
        Ellipse2D.Double rightEye = new Ellipse2D.Double(208, 142, 6, 10);
        fillShape(g2, leftEye, FOX_DARK);
        fillShape(g2, rightEye, FOX_DARK);

        Ellipse2D.Double nose = new Ellipse2D.Double(197, 165, 8, 6);
        fillShape(g2, nose, FOX_DARK);
        g2.draw(new QuadCurve2D.Double(201, 170, 202, 178, 196, 182));
        g2.draw(new QuadCurve2D.Double(203, 170, 206, 178, 210, 182));

        g2.setStroke(new BasicStroke(3f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        g2.draw(new QuadCurve2D.Double(165, 190, 210, 205, 255, 190));
    }

    private void fillAndOutline(Graphics2D g2, Path2D shape, Color fill) {
        fillShape(g2, shape, fill);
        g2.setColor(Color.BLACK);
        g2.draw(shape);
    }

    private void fillShape(Graphics2D g2, java.awt.Shape shape, Color fill) {
        Color previous = g2.getColor();
        g2.setColor(fill);
        g2.fill(shape);
        g2.setColor(previous);
    }
}
