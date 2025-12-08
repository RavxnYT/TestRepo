import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;

/**
 * Simple Java2D scene that sketches a stylised fennec fox (ID ending 0/1).
 */
public class Skel extends JApplet {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setTitle("Fennec Fox");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JApplet applete = new Skel();
        applete.init();
        frame.getContentPane().add(applete);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void init() {
        JPanel panel = new JApp1Panel();
        getContentPane().add(panel);
    }
}

class JApp1Panel extends JPanel {
    private static final Color BACKGROUND_TOP = new Color(26, 26, 32);
    private static final Color BACKGROUND_BOTTOM = new Color(70, 70, 78);
    private static final Color ROCK_TOP = new Color(120, 120, 132);
    private static final Color ROCK_BOTTOM = new Color(68, 68, 78);
    private static final Color FOX_BACK = new Color(184, 134, 92);
    private static final Color FOX_BELLY = new Color(253, 248, 240);
    private static final Color FOX_WHITE = new Color(255, 255, 255);
    private static final Stroke FOX_OUTLINE = new BasicStroke(3f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);

    public JApp1Panel() {
        setPreferredSize(new Dimension(640, 480));
        setBackground(BACKGROUND_BOTTOM);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

        paintBackground(g2);
        paintRock(g2);
        paintTail(g2);
        paintBody(g2);
        paintHead(g2);
        paintLegs(g2);
        paintFacialFeatures(g2);
        paintCaption(g2);
    }

    private void paintBackground(Graphics2D g2) {
        GradientPaint dusk = new GradientPaint(0, 0, BACKGROUND_TOP, 0, getHeight(), BACKGROUND_BOTTOM);
        g2.setPaint(dusk);
        g2.fillRect(0, 0, getWidth(), getHeight());

        RadialGradientPaint glow = new RadialGradientPaint(
                new Point2D.Double(460, 110),
                220,
                new float[]{0f, 1f},
                new Color[]{new Color(255, 255, 255, 35), new Color(255, 255, 255, 0)});
        g2.setPaint(glow);
        g2.fill(new Rectangle2D.Double(200, 50, 320, 220));
    }

    private void paintRock(Graphics2D g2) {
        Shape rock = new RoundRectangle2D.Double(40, 340, 560, 110, 90, 90);
        GradientPaint rockPaint = new GradientPaint(0, 340, ROCK_TOP, 0, 450, ROCK_BOTTOM);
        g2.setPaint(rockPaint);
        g2.fill(rock);
        g2.setColor(new Color(50, 50, 60));
        g2.setStroke(new BasicStroke(3f));
        g2.draw(rock);
    }

    private void paintTail(Graphics2D g2) {
        GeneralPath tail = new GeneralPath();
        tail.moveTo(150, 320);
        tail.curveTo(70, 300, 80, 220, 210, 220);
        tail.curveTo(260, 230, 265, 290, 230, 340);
        tail.curveTo(205, 365, 170, 360, 150, 350);
        tail.closePath();
        GradientPaint tailPaint = new GradientPaint(150, 220, FOX_BACK, 150, 360, FOX_WHITE);
        g2.setPaint(tailPaint);
        g2.fill(tail);
        g2.setColor(new Color(120, 85, 60));
        g2.setStroke(FOX_OUTLINE);
        g2.draw(tail);
    }

    private void paintBody(Graphics2D g2) {
        GeneralPath body = new GeneralPath();
        body.moveTo(220, 230);
        body.curveTo(160, 260, 165, 340, 230, 360);
        body.curveTo(360, 390, 430, 320, 420, 250);
        body.curveTo(400, 200, 300, 200, 250, 210);
        body.closePath();
        g2.setPaint(new GradientPaint(220, 220, FOX_BACK, 220, 390, FOX_BELLY));
        g2.fill(body);
        g2.setColor(new Color(120, 85, 55));
        g2.setStroke(FOX_OUTLINE);
        g2.draw(body);

        Shape chest = new QuadCurve2D.Double(245, 250, 268, 330, 235, 350);
        g2.setStroke(new BasicStroke(16f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        g2.setPaint(new GradientPaint(240, 260, FOX_BELLY, 240, 350, FOX_WHITE));
        g2.draw(chest);
    }

    private void paintLegs(Graphics2D g2) {
        Shape nearLeg = new RoundRectangle2D.Double(250, 330, 32, 85, 22, 22);
        Shape farLeg = new RoundRectangle2D.Double(290, 330, 30, 85, 22, 22);
        Shape hindLeg = new RoundRectangle2D.Double(360, 330, 38, 88, 24, 24);

        fillWithGradient(g2, nearLeg, FOX_BACK, FOX_BELLY);
        fillWithGradient(g2, farLeg, FOX_BACK, FOX_BELLY);
        fillWithGradient(g2, hindLeg, FOX_BACK, FOX_BELLY);
        g2.setColor(new Color(110, 80, 55));
        g2.setStroke(new BasicStroke(2.4f));
        g2.draw(nearLeg);
        g2.draw(farLeg);
        g2.draw(hindLeg);
    }

    private void paintHead(Graphics2D g2) {
        Area head = new Area(new Ellipse2D.Double(290, 190, 120, 90));
        Area flatten = new Area(new Rectangle2D.Double(320, 235, 90, 60));
        head.subtract(flatten);
        g2.setPaint(new GradientPaint(290, 190, FOX_BACK, 290, 270, FOX_BELLY));
        g2.fill(head);
        g2.setColor(new Color(120, 85, 55));
        g2.setStroke(FOX_OUTLINE);
        g2.draw(head);

        GeneralPath earLeft = new GeneralPath();
        earLeft.moveTo(320, 192);
        earLeft.curveTo(250, 120, 220, 110, 235, 195);
        earLeft.curveTo(245, 240, 285, 230, 318, 220);
        earLeft.closePath();
        g2.setPaint(new GradientPaint(250, 120, FOX_BACK, 250, 220, FOX_BELLY));
        g2.fill(earLeft);
        g2.setColor(new Color(115, 80, 55));
        g2.draw(earLeft);

        GeneralPath earLeftInner = new GeneralPath();
        earLeftInner.moveTo(310, 198);
        earLeftInner.curveTo(270, 135, 245, 140, 250, 200);
        earLeftInner.curveTo(258, 220, 290, 220, 302, 212);
        earLeftInner.closePath();
        g2.setPaint(new GradientPaint(270, 150, FOX_WHITE, 270, 220, FOX_BELLY));
        g2.fill(earLeftInner);

        GeneralPath earRight = new GeneralPath();
        earRight.moveTo(370, 192);
        earRight.curveTo(440, 120, 500, 120, 485, 195);
        earRight.curveTo(470, 240, 410, 240, 380, 215);
        earRight.closePath();
        g2.setPaint(new GradientPaint(430, 120, FOX_BACK, 430, 220, FOX_BELLY));
        g2.fill(earRight);
        g2.setColor(new Color(115, 80, 55));
        g2.draw(earRight);

        GeneralPath earRightInner = new GeneralPath();
        earRightInner.moveTo(382, 198);
        earRightInner.curveTo(430, 140, 470, 145, 465, 205);
        earRightInner.curveTo(455, 225, 410, 220, 392, 212);
        earRightInner.closePath();
        g2.setPaint(new GradientPaint(430, 150, FOX_WHITE, 430, 220, FOX_BELLY));
        g2.fill(earRightInner);
    }

    private void paintFacialFeatures(Graphics2D g2) {
        Shape muzzle = new Ellipse2D.Double(334, 232, 68, 46);
        g2.setPaint(new GradientPaint(334, 232, FOX_WHITE, 334, 278, FOX_BELLY));
        g2.fill(muzzle);
        g2.setColor(new Color(100, 80, 65));
        g2.setStroke(new BasicStroke(1.8f));
        g2.draw(muzzle);

        Shape leftEye = new Ellipse2D.Double(333, 220, 18, 12);
        Shape rightEye = new Ellipse2D.Double(380, 220, 18, 12);
        g2.setColor(new Color(25, 25, 30));
        g2.fill(leftEye);
        g2.fill(rightEye);
        g2.setColor(new Color(255, 255, 255, 90));
        g2.fill(new Ellipse2D.Double(336, 222, 5, 4));
        g2.fill(new Ellipse2D.Double(383, 222, 5, 4));

        Shape nose = new RoundRectangle2D.Double(363, 248, 16, 12, 10, 10);
        g2.setColor(new Color(35, 35, 40));
        g2.fill(nose);

        g2.setStroke(new BasicStroke(1.2f));
        g2.draw(new QuadCurve2D.Double(350, 260, 352, 272, 332, 272));
        g2.draw(new QuadCurve2D.Double(392, 260, 390, 272, 410, 272));
    }

    private void paintCaption(Graphics2D g2) {
        g2.setColor(Color.WHITE);
        g2.setFont(new Font("Serif", Font.BOLD, 20));
        String caption = "ID ends with 0 or 1";
        FontMetrics fm = g2.getFontMetrics();
        int textWidth = fm.stringWidth(caption);
        g2.drawString(caption, (getWidth() - textWidth) / 2, 460);
    }

    private void fillWithGradient(Graphics2D g2, Shape shape, Color top, Color bottom) {
        Rectangle bounds = shape.getBounds();
        GradientPaint grad = new GradientPaint(
                bounds.x,
                bounds.y,
                top,
                bounds.x,
                bounds.y + bounds.height,
                bottom);
        g2.setPaint(grad);
        g2.fill(shape);
    }
}
