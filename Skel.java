import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.RoundRectangle2D;
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
        int[] tailX = {175, 130, 70, 85, 145, 205};
        int[] tailY = {190, 150, 210, 260, 255, 205};
        Polygon tail = new Polygon(tailX, tailY, tailX.length);
        fillAndOutline(g2, tail, FOX_ORANGE);

        int[] tailTipX = {100, 80, 105, 150};
        int[] tailTipY = {180, 220, 240, 220};
        Polygon tailTip = new Polygon(tailTipX, tailTipY, tailTipX.length);
        fillAndOutline(g2, tailTip, FOX_WHITE);

        RoundRectangle2D body = new RoundRectangle2D.Double(180, 150, 120, 190, 70, 70);
        fillAndOutline(g2, body, FOX_ORANGE);

        RoundRectangle2D belly = new RoundRectangle2D.Double(200, 160, 80, 170, 60, 60);
        fillAndOutline(g2, belly, FOX_WHITE);

        RoundRectangle2D leftLeg = new RoundRectangle2D.Double(200, 260, 35, 95, 20, 20);
        RoundRectangle2D rightLeg = new RoundRectangle2D.Double(245, 260, 35, 95, 20, 20);
        fillAndOutline(g2, leftLeg, FOX_DARK);
        fillAndOutline(g2, rightLeg, FOX_DARK);

        Ellipse2D head = new Ellipse2D.Double(195, 85, 95, 90);
        fillAndOutline(g2, head, FOX_ORANGE);

        RoundRectangle2D face = new RoundRectangle2D.Double(205, 115, 70, 65, 60, 60);
        fillAndOutline(g2, face, FOX_WHITE);

        Polygon leftEar = new Polygon(new int[]{205, 190, 215}, new int[]{95, 45, 70}, 3);
        Polygon rightEar = new Polygon(new int[]{270, 285, 260}, new int[]{95, 45, 70}, 3);
        fillAndOutline(g2, leftEar, FOX_ORANGE);
        fillAndOutline(g2, rightEar, FOX_ORANGE);

        Polygon leftInnerEar = new Polygon(new int[]{208, 197, 213}, new int[]{90, 55, 70}, 3);
        Polygon rightInnerEar = new Polygon(new int[]{267, 278, 262}, new int[]{90, 55, 70}, 3);
        fillShape(g2, leftInnerEar, FOX_PINK);
        fillShape(g2, rightInnerEar, FOX_PINK);

        g2.setColor(FOX_DARK);
        g2.fillOval(220, 140, 10, 12);
        g2.fillOval(245, 140, 10, 12);
        g2.fillOval(233, 165, 8, 6);

        g2.setColor(Color.BLACK);
        g2.drawArc(215, 160, 40, 25, 200, 140);
        g2.drawLine(237, 172, 230, 182);
        g2.drawLine(237, 172, 244, 182);
    }

    private void fillAndOutline(Graphics2D g2, Shape shape, Color fill) {
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
