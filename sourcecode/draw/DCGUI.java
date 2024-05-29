package draw;

import java.awt.Graphics2D;
import model.Circuit.Circuit;
import model.Circuit.ParallelCircuit;

public class DCGUI extends ElementGUI {

    public DCGUI(Circuit circuit) {
        super(circuit);
    }

    @Override
    public void paintComponent(Graphics2D g2d) {
        if (circuit instanceof ParallelCircuit) {
            g2d.rotate(Math.toRadians(90), x, y);

            draw(g2d);

            g2d.rotate(-Math.toRadians(90), x, y);
            this.drawString(g2d, circuit.getSource().toString());
            return;
        }

        draw(g2d);
        this.drawString(g2d, circuit.getSource().toString());
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

        g2d.drawLine(x - width / 2 + width / 8, y, x - width / 2 + width * 3 / 8, y);
        g2d.drawLine(x - width / 2 + width / 4, y - height / 2 + height * 3 / 8, x - width / 2 + width / 4, y - height / 2 + height * 5 / 8);

        g2d.drawLine(x - width / 2 + width * 5 / 8, y, x - width / 2 + width * 7 / 8, y);

        g2d.drawLine(x + width / 2, y, x + length / 2, y);
    }
}
