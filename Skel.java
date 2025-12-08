import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.geom.*;
import java.util.Random;
import java.awt.image.BufferedImage;

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
    private final TexturePaint furTexture;
    private final TexturePaint earTexture;
    private final TexturePaint rockTexture;

    public JApp1Panel() {
        setPreferredSize(new Dimension(640, 480));
        furTexture = createFurTexture(new Color(246, 226, 196), new Color(222, 194, 153));
        earTexture = createFurTexture(new Color(255, 220, 228), new Color(235, 200, 210));
        rockTexture = createRockTexture();
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
        GradientPaint dusk = new GradientPaint(0, 0, new Color(22, 22, 22), 0, getHeight(), new Color(54, 54, 54));
        g2.setPaint(dusk);
        g2.fillRect(0, 0, getWidth(), getHeight());

        RadialGradientPaint glow = new RadialGradientPaint(new Point2D.Double(420, 120), 220,
                new float[]{0f, 1f},
                new Color[]{new Color(255, 255, 255, 60), new Color(255, 255, 255, 0)});
        g2.setPaint(glow);
        g2.fill(new Rectangle2D.Double(180, 0, 480, 240));
    }

    private void paintRock(Graphics2D g2) {
        Shape rock = new RoundRectangle2D.Double(40, 330, 560, 120, 120, 120);
        g2.setPaint(rockTexture);
        g2.fill(rock);
        g2.setColor(new Color(40, 40, 40));
        g2.setStroke(new BasicStroke(4f));
        g2.draw(rock);
    }

    private void paintTail(Graphics2D g2) {
        GeneralPath tail = new GeneralPath();
        tail.moveTo(110, 320);
        tail.curveTo(40, 310, 50, 230, 140, 220);
        tail.curveTo(200, 210, 220, 260, 230, 300);
        tail.curveTo(240, 340, 210, 360, 150, 360);
        tail.closePath();
        g2.setPaint(furTexture);
        g2.fill(tail);
        g2.setColor(new Color(155, 115, 78));
        g2.setStroke(new BasicStroke(3f));
        g2.draw(tail);

        GeneralPath tailTip = new GeneralPath();
        tailTip.moveTo(90, 305);
        tailTip.curveTo(50, 280, 55, 240, 128, 230);
        tailTip.curveTo(160, 230, 180, 250, 190, 280);
        tailTip.curveTo(150, 306, 130, 320, 100, 322);
        tailTip.closePath();
        g2.setPaint(new Color(248, 244, 238));
        g2.fill(tailTip);
    }

    private void paintBody(Graphics2D g2) {
        GeneralPath body = new GeneralPath();
        body.moveTo(220, 230);
        body.curveTo(160, 250, 160, 330, 220, 360);
        body.curveTo(360, 390, 430, 320, 420, 250);
        body.curveTo(400, 200, 300, 200, 250, 210);
        body.closePath();
        g2.setPaint(furTexture);
        g2.fill(body);
        g2.setColor(new Color(150, 110, 70));
        g2.setStroke(new BasicStroke(4f));
        g2.draw(body);
    }

    private void paintLegs(Graphics2D g2) {
        Shape nearLeg = new RoundRectangle2D.Double(250, 320, 30, 90, 25, 25);
        Shape farLeg = new RoundRectangle2D.Double(285, 320, 28, 88, 25, 25);
        Shape hindLeg = new RoundRectangle2D.Double(360, 320, 36, 90, 25, 25);

        g2.setPaint(new Color(247, 237, 220));
        g2.fill(nearLeg);
        g2.fill(farLeg);
        g2.fill(hindLeg);
        g2.setColor(new Color(150, 120, 90));
        g2.draw(nearLeg);
        g2.draw(farLeg);
        g2.draw(hindLeg);

        g2.setStroke(new BasicStroke(2f));
        g2.drawLine(255, 398, 270, 398);
        g2.drawLine(290, 398, 305, 398);
        g2.drawLine(365, 398, 386, 398);
    }

    private void paintHead(Graphics2D g2) {
        Area head = new Area(new Ellipse2D.Double(290, 190, 120, 90));
        Area flatten = new Area(new Rectangle2D.Double(310, 230, 90, 90));
        head.subtract(flatten);
        g2.setPaint(furTexture);
        g2.fill(head);
        g2.setColor(new Color(150, 110, 70));
        g2.setStroke(new BasicStroke(3f));
        g2.draw(head);

        GeneralPath earLeft = new GeneralPath();
        earLeft.moveTo(320, 190);
        earLeft.curveTo(260, 110, 200, 90, 220, 180);
        earLeft.curveTo(240, 230, 285, 235, 320, 220);
        earLeft.closePath();
        g2.setPaint(furTexture);
        g2.fill(earLeft);
        g2.setColor(new Color(140, 105, 70));
        g2.draw(earLeft);

        GeneralPath earLeftInner = new GeneralPath();
        earLeftInner.moveTo(310, 195);
        earLeftInner.curveTo(270, 130, 230, 120, 240, 190);
        earLeftInner.curveTo(250, 220, 285, 220, 305, 212);
        earLeftInner.closePath();
        g2.setPaint(earTexture);
        g2.fill(earLeftInner);

        GeneralPath earRight = new GeneralPath();
        earRight.moveTo(370, 190);
        earRight.curveTo(430, 110, 510, 100, 490, 190);
        earRight.curveTo(470, 240, 410, 240, 380, 215);
        earRight.closePath();
        g2.setPaint(furTexture);
        g2.fill(earRight);
        g2.setColor(new Color(140, 105, 70));
        g2.draw(earRight);

        GeneralPath earRightInner = new GeneralPath();
        earRightInner.moveTo(380, 195);
        earRightInner.curveTo(420, 140, 480, 135, 470, 200);
        earRightInner.curveTo(458, 220, 410, 220, 392, 212);
        earRightInner.closePath();
        g2.setPaint(earTexture);
        g2.fill(earRightInner);
    }

    private void paintFacialFeatures(Graphics2D g2) {
        GradientPaint muzzlePaint = new GradientPaint(340, 230, new Color(255, 255, 255), 370, 250,
                new Color(240, 226, 210));
        Shape muzzle = new Ellipse2D.Double(330, 230, 70, 50);
        g2.setPaint(muzzlePaint);
        g2.fill(muzzle);

        g2.setColor(new Color(120, 90, 60));
        g2.setStroke(new BasicStroke(2f));
        g2.draw(muzzle);

        Shape leftEye = new Ellipse2D.Double(330, 220, 18, 12);
        Shape rightEye = new Ellipse2D.Double(378, 220, 18, 12);
        g2.setColor(new Color(20, 20, 20));
        g2.fill(leftEye);
        g2.fill(rightEye);
        g2.setColor(new Color(255, 255, 255, 120));
        g2.fill(new Ellipse2D.Double(334, 222, 6, 4));
        g2.fill(new Ellipse2D.Double(382, 222, 6, 4));

        Shape nose = new RoundRectangle2D.Double(362, 250, 16, 12, 10, 10);
        g2.setColor(new Color(40, 40, 40));
        g2.fill(nose);

        g2.setStroke(new BasicStroke(1.5f));
        for (int i = 0; i < 3; i++) {
            g2.draw(new Line2D.Double(348, 260 + i * 4, 310, 250 + i * 6));
            g2.draw(new Line2D.Double(392, 260 + i * 4, 430, 250 + i * 6));
        }
    }

    private void paintCaption(Graphics2D g2) {
        g2.setColor(Color.WHITE);
        g2.setFont(new Font("Serif", Font.BOLD, 20));
        String caption = "ID ends with 0 or 1";
        FontMetrics fm = g2.getFontMetrics();
        int textWidth = fm.stringWidth(caption);
        g2.drawString(caption, (getWidth() - textWidth) / 2, 460);
    }

    private TexturePaint createFurTexture(Color light, Color shadow) {
        int size = 40;
        BufferedImage img = new BufferedImage(size, size, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = img.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(light);
        g2.fillRect(0, 0, size, size);
        g2.setColor(shadow);
        for (int i = 0; i < size; i += 6) {
            g2.setStroke(new BasicStroke(3f));
            g2.drawLine(0, i, size, i + 4);
        }
        g2.dispose();
        Rectangle anchor = new Rectangle(0, 0, size, size);
        return new TexturePaint(img, anchor);
    }

    private TexturePaint createRockTexture() {
        int size = 60;
        BufferedImage img = new BufferedImage(size, size, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = img.createGraphics();
        g2.setColor(new Color(95, 95, 95));
        g2.fillRect(0, 0, size, size);
        g2.setColor(new Color(70, 70, 70));
        Random rnd = new Random(42);
        for (int i = 0; i < 90; i++) {
            int x = rnd.nextInt(size);
            int y = rnd.nextInt(size);
            int r = 3 + rnd.nextInt(5);
            g2.fillOval(x, y, r, r);
        }
        g2.dispose();
        Rectangle anchor = new Rectangle(0, 0, size, size);
        return new TexturePaint(img, anchor);
    }
}
