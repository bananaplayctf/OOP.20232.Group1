package draw;

import java.awt.Graphics2D;
import model.Circuit.*;

public class ACGUI extends ElementGUI {

    public ACGUI(Circuit circuit) {
        super(circuit);
    }

    @Override
    public void paintComponent(Graphics2D g2d) {
        if (circuit instanceof ParallelCircuit) {
            g2d.rotate(Math.toRadians(90), x, y);

            draw(g2d);

            g2d.rotate(-Math.toRadians(90), x, y);
            drawString(g2d, circuit.getSource().toString());
            return;
        }

        draw(g2d);
        drawString(g2d, circuit.getSource().toString());
    }

    public void draw(Graphics2D g2d) {
        if (circuit instanceof ParallelCircuit) {
            g2d.drawLine(x - length / 2, y, x - length / 2, y - 800);
            g2d.drawLine(x + length / 2, y, x + length / 2, y - 800);
        } else {
            this.length = 800;
            g2d.drawLine(x - length / 2, y, x - length / 2, y - 200);
            g2d.drawLine(x + length / 2, y, x + length / 2, y - 200);
        }

        g2d.drawLine(x - length / 2, y, x - width / 2, y);

        g2d.drawOval(x - width / 2, y - height / 2, width, height);
        g2d.drawArc(x - width / 2 + width / 4, y - height / 2 + height * 3 / 8, width / 4, height / 4, 0, 180);
        g2d.drawArc(x, y - height / 2 + width * 3 / 8, width / 4, height / 4, 180, 180);

        g2d.drawLine(x + width / 2, y, x + length / 2, y);
    }
}
