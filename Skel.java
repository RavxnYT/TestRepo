import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

/**
 * Simple Swing/JApplet container that paints a stylized fox.
 */
public class Skel extends JApplet {

    /**
     * Launches the applet inside a regular Swing frame, so the sketch can run
     * as a desktop application.
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Simple Fox");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            JApplet applet = new Skel();
            applet.init();
            frame.getContentPane().add(applet);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }

    @Override
    public void init() {
        JPanel panel = new FoxPanel();
        getContentPane().add(panel);
    }
}

/**
 * Panel responsible for the low-detail fox drawing.
 */
class FoxPanel extends JPanel {
    private static final Color FUR = new Color(241, 138, 45);
    private static final Color CREAM = new Color(255, 240, 214);
    private static final Color DARK = new Color(24, 24, 24);

    FoxPanel() {
        setPreferredSize(new Dimension(640, 480));
        setBackground(Color.WHITE);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        double baseWidth = 640.0;
        double baseHeight = 480.0;
        double scale = Math.min(getWidth() / baseWidth, getHeight() / baseHeight);
        double translateX = (getWidth() - baseWidth * scale) / 2.0;
        double translateY = (getHeight() - baseHeight * scale) / 2.0;

        g2.translate(translateX, translateY);
        g2.scale(scale, scale);

        drawFox(g2);
        g2.dispose();
    }

    private void drawFox(Graphics2D g2) {
        GeneralPath tail = new GeneralPath();
        tail.moveTo(420, 260);
        tail.curveTo(520, 190, 580, 320, 520, 390);
        tail.curveTo(500, 420, 360, 400, 372, 310);
        tail.closePath();

        GeneralPath tailTip = new GeneralPath();
        tailTip.moveTo(505, 255);
        tailTip.curveTo(545, 320, 500, 375, 450, 350);
        tailTip.curveTo(470, 300, 490, 270, 505, 255);
        tailTip.closePath();

        RoundRectangle2D body = new RoundRectangle2D.Double(220, 250, 170, 170, 150, 150);

        GeneralPath belly = new GeneralPath();
        belly.moveTo(260, 260);
        belly.curveTo(320, 320, 330, 360, 315, 410);
        belly.curveTo(280, 400, 250, 340, 260, 260);
        belly.closePath();

        GeneralPath head = new GeneralPath();
        head.moveTo(200, 200);
        head.curveTo(240, 120, 360, 120, 400, 200);
        head.curveTo(420, 250, 180, 250, 200, 200);
        head.closePath();

        GeneralPath faceMask = new GeneralPath();
        faceMask.moveTo(220, 200);
        faceMask.curveTo(270, 250, 330, 250, 380, 200);
        faceMask.curveTo(360, 230, 240, 230, 220, 200);
        faceMask.closePath();

        GeneralPath earLeft = new GeneralPath();
        earLeft.moveTo(225, 170);
        earLeft.curveTo(225, 120, 260, 110, 270, 175);
        earLeft.curveTo(250, 165, 235, 165, 225, 170);
        earLeft.closePath();

        GeneralPath earRight = new GeneralPath();
        earRight.moveTo(375, 170);
        earRight.curveTo(380, 110, 415, 120, 415, 175);
        earRight.curveTo(400, 165, 385, 165, 375, 170);
        earRight.closePath();

        GeneralPath earLeftInner = new GeneralPath();
        earLeftInner.moveTo(242, 165);
        earLeftInner.curveTo(240, 135, 260, 135, 260, 170);
        earLeftInner.closePath();

        GeneralPath earRightInner = new GeneralPath();
        earRightInner.moveTo(387, 165);
        earRightInner.curveTo(395, 135, 405, 140, 400, 170);
        earRightInner.closePath();

        GeneralPath pawLeft = new GeneralPath();
        pawLeft.moveTo(255, 405);
        pawLeft.curveTo(240, 430, 245, 450, 265, 450);
        pawLeft.curveTo(280, 450, 285, 430, 275, 405);
        pawLeft.closePath();

        GeneralPath pawRight = new GeneralPath();
        pawRight.moveTo(325, 405);
        pawRight.curveTo(310, 430, 315, 450, 335, 450);
        pawRight.curveTo(350, 450, 355, 430, 345, 405);
        pawRight.closePath();

        g2.setColor(FUR);
        g2.fill(tail);
        g2.fill(body);
        g2.fill(head);
        g2.fill(earLeft);
        g2.fill(earRight);

        g2.setColor(CREAM);
        g2.fill(tailTip);
        g2.fill(belly);
        g2.fill(faceMask);
        g2.fill(earLeftInner);
        g2.fill(earRightInner);

        g2.setColor(DARK);
        g2.fill(pawLeft);
        g2.fill(pawRight);

        Ellipse2D leftEye = new Ellipse2D.Double(275, 215, 12, 18);
        Ellipse2D rightEye = new Ellipse2D.Double(330, 215, 12, 18);
        Ellipse2D nose = new Ellipse2D.Double(300, 235, 18, 12);

        QuadCurve2D mouthLeft = new QuadCurve2D.Double(309, 243, 300, 255, 292, 250);
        QuadCurve2D mouthRight = new QuadCurve2D.Double(309, 243, 318, 255, 326, 250);

        g2.fill(leftEye);
        g2.fill(rightEye);
        g2.fill(nose);
        g2.draw(mouthLeft);
        g2.draw(mouthRight);

        // Outline the major shapes for a sticker-like look.
        g2.setStroke(new BasicStroke(6f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        g2.draw(tail);
        g2.draw(body);
        g2.draw(head);
        g2.draw(earLeft);
        g2.draw(earRight);
        g2.draw(pawLeft);
        g2.draw(pawRight);
    }
}
