package draw;

import java.awt.Graphics2D;
import model.Circuit.Circuit;
import model.Circuit.ParallelCircuit;

abstract class ElementGUI {

    protected int x, y;
    protected int width, height;
    protected Circuit circuit;
    protected int length;

    public ElementGUI() {
        
    }
    
    public ElementGUI(Circuit circuit) {
        this.circuit = circuit;
        this.length = (circuit instanceof ParallelCircuit) ? 200 : (800 / this.circuit.getTotalComponents());
    }

    public void setPosition(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }


    public void drawString(Graphics2D g2d, String info) {
        String[] lines = info.split("\n");
        if (circuit instanceof ParallelCircuit) {
            for (int i = 0; i < lines.length; i++) {
                g2d.drawString(lines[i], x + height, y + g2d.getFontMetrics().getHeight() * (i - lines.length));
            }
            
            return;
        }
        
        for (int i = 0; i < lines.length; i++) {
            g2d.drawString(lines[i], x - width / 2, y - height / 2 + g2d.getFontMetrics().getHeight() * (i - lines.length));
        }
    }

    abstract public void paintComponent(Graphics2D g2d);

}
