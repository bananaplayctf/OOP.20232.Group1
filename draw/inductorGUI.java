package draw;

import java.awt.Graphics2D;
import model.Circuit.Circuit;
import model.Circuit.ParallelCircuit;

public class inductorGUI extends ElementGUI {
    private int id;
    
    public inductorGUI(Circuit circuit, int id) {
        super(circuit);
        this.id = id;
    }

    @Override
    public void paintComponent(Graphics2D g2d) {

        if (circuit instanceof ParallelCircuit) {
            g2d.rotate(Math.toRadians(90), x, y);
            draw(g2d);
            g2d.rotate(-Math.toRadians(90), x, y);
            this.drawString(g2d, circuit.getElectricalComponents().get(id).toString());
            return;
        }

        draw(g2d);
        this.drawString(g2d, circuit.getElectricalComponents().get(id).toString());
    }

    public void draw(Graphics2D g2d) {
        
        g2d.drawLine(x - length / 2, y, x - width / 2, y);

        for (int i = 0; i < 4; i++) {
            g2d.drawArc(x - width / 2 + 20 * i, y - height / 2, width / 3, height, 0, 180);
        }

        for (int i = 1; i < 4; i++) {
            g2d.drawArc(x - width / 2 + 20 * i, y - height / 3, width / 9, height * 2 / 3, 180, 180);
        }
        
        g2d.drawLine(x + width / 2, y, x + length / 2, y);
    }
}
