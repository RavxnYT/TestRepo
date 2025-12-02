import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

/**
 * Simple Java2D sketch that draws a petal-like ellipse rotating inside
 * a circular boundary. Every full revolution leaves a permanent outline
 * and the ellipse grows until 10 outlines have been printed.
 */
public class RotatingEllipseAnimator extends JPanel implements ActionListener {

    private static final int CANVAS_SIZE = 600;
    private static final int FPS = 60;
    private static final Color BACKGROUND = new Color(245, 245, 245);

    private static final double BASE_WIDTH = 75.0;
    private static final double BASE_HEIGHT = 120.0;
    private static final double SCALE_INCREMENT = 0.12;
    private static final int MAX_OUTLINES = 10;

    private final Timer timer;
    private final List<Shape> outlinePrints = new ArrayList<>();

    private double angle = 0.0;
    private double currentScale = 1.0;
    private int completedRevolutions = 0;
    private final double angleStep = Math.PI / 90.0; // 2 degrees per frame
    private Shape livePetal;

    public RotatingEllipseAnimator() {
        setPreferredSize(new Dimension(CANVAS_SIZE, CANVAS_SIZE));
        setBackground(BACKGROUND);
        timer = new Timer(1000 / FPS, this);
    }

    @Override
    public void addNotify() {
        super.addNotify();
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        double cx = getWidth() / 2.0;
        double cy = getHeight() / 2.0;
        double maxScale = 1.0 + SCALE_INCREMENT * (MAX_OUTLINES - 1);
        double maxRadius = BASE_HEIGHT * maxScale;

        g2.setColor(Color.DARK_GRAY);
        g2.setStroke(new BasicStroke(1.5f));
        g2.draw(new Ellipse2D.Double(cx - maxRadius, cy - maxRadius, maxRadius * 2, maxRadius * 2));

        double innerRadius = BASE_HEIGHT * 0.8;
        g2.draw(new Ellipse2D.Double(cx - innerRadius, cy - innerRadius, innerRadius * 2, innerRadius * 2));

        g2.setColor(Color.BLACK);
        g2.setStroke(new BasicStroke(1.2f));
        for (Shape imprint : outlinePrints) {
            g2.draw(imprint);
        }

        if (livePetal != null) {
            g2.setColor(new Color(60, 60, 60));
            g2.fill(livePetal);
            g2.setColor(Color.BLACK);
            g2.draw(livePetal);
        }

        g2.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (completedRevolutions >= MAX_OUTLINES) {
            timer.stop();
            return;
        }

        angle += angleStep;
        Shape nextPetal = buildPetal(angle, currentScale);
        outlinePrints.add(nextPetal);
        livePetal = nextPetal;

        if (angle >= Math.PI * 2) {
            angle -= Math.PI * 2;
            currentScale += SCALE_INCREMENT;
            completedRevolutions++;
        }

        repaint();
    }

    private Shape buildPetal(double rotation, double scale) {
        double width = BASE_WIDTH * scale;
        double height = BASE_HEIGHT * scale;

        // Build the top half of an ellipse so that the flat edge stays anchored at the center.
        Area halfEllipse = new Area(new Ellipse2D.Double(-width / 2.0, -height, width, height * 2.0));
        halfEllipse.subtract(new Area(new Rectangle2D.Double(-width, 0, width * 2.0, height * 2.0)));

        double cx = getWidth() > 0 ? getWidth() / 2.0 : CANVAS_SIZE / 2.0;
        double cy = getHeight() > 0 ? getHeight() / 2.0 : CANVAS_SIZE / 2.0;

        AffineTransform tx = new AffineTransform();
        tx.translate(cx, cy);
        tx.rotate(rotation);
        return tx.createTransformedShape(halfEllipse);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Growing Ellipse Animator");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setResizable(false);
            frame.add(new RotatingEllipseAnimator());
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
