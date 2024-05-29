package draw;

import java.awt.Graphics;
import java.awt.Graphics2D;
import model.Circuit.Circuit;
import model.Circuit.ParallelCircuit;


public class ResistorGUI extends ElementGUI {
    private int id;

    public ResistorGUI(Circuit circuit, int id) {
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

    public void draw(Graphics g2d) {
        
        g2d.drawLine(x - length / 2, y, x - width / 2, y);
        
        for (int i = 0; i < 10; i++) {
            switch (i % 4) {
                case 0 ->
                    g2d.drawLine(x - width / 2 + 10 * i, y, x - width / 2 + 10 * (i + 1), y - height / 2);
                case 1 ->
                    g2d.drawLine(x - width / 2 + 10 * i, y - height / 2, x - width / 2 + 10 * (i + 1), y);
                case 2 ->
                    g2d.drawLine(x - width / 2 + 10 * i, y, x - width / 2 + 10 * (i + 1), y + height / 2);
                case 3 ->
                    g2d.drawLine(x - width / 2 + 10 * i, y + height / 2, x - width / 2 + 10 * (i + 1), y);
                default -> {
                }
            }
        }
        
        g2d.drawLine(x + width / 2, y, x + length / 2, y);
    }

}
