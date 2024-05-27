package draw;

import java.awt.BasicStroke;
import model.Source.*;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import javax.swing.JPanel;

import model.Circuit.*;
import model.ElectricalComponent.*;

public class DrawPanel extends JPanel {

    private Circuit circuit;
    private int[] componentPositionX;

    public DrawPanel(Circuit circuit) {
        this.circuit = circuit;
    }

    public void setComponentPosition() {
        componentPositionX = new int[5];
        int count = circuit.getTotalComponents();
        int distance = 800 / count;
        if (circuit instanceof SerialCircuit) {
            for (int i = 0; i < count; i++) {
                componentPositionX[i] = 200 + distance / 2 + distance * i;
            }
        } else {
            for (int i = 0; i < count; i++) {
                componentPositionX[i] = 200 + distance * (i + 1);
            }
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g2d.setStroke(new BasicStroke(3));
        
        Font font = new Font("Arial", Font.BOLD, 20);
        g2d.setFont(font);

        ArrayList<ElectricalComponent> ElecComp = circuit.getElectricalComponents();
        int centerX, centerY;
        if (circuit instanceof SerialCircuit) {
            for (int i = 0; i < ElecComp.size(); i++) {
                centerX = componentPositionX[i];

                centerY = 100;

                switch (checkComponent(ElecComp.get(i))) {
                    case 1 ->
                        paintElecComponent(g2d, new capacitorGUI(circuit, i), centerX, centerY, 20, 30);
                    case 2 ->
                        paintElecComponent(g2d, new resistorGUI(circuit, i), centerX, centerY, 100, 30);
                    case 3 ->
                        paintElecComponent(g2d, new inductorGUI(circuit, i), centerX, centerY, 90, 30);
                    default -> {
                    }
                }
            }
        } else {
            for (int i = 0; i < ElecComp.size(); i++) {
                centerX = componentPositionX[i];
                centerY = 200;
                switch (checkComponent(ElecComp.get(i))) {
                    case 1 ->
                        this.paintElecComponent(g2d, new capacitorGUI(circuit, i), centerX, centerY, 20, 30);
                    case 2 ->
                        this.paintElecComponent(g2d, new resistorGUI(circuit, i), centerX, centerY, 100, 30);
                    case 3 ->
                        this.paintElecComponent(g2d, new inductorGUI(circuit, i), centerX, centerY, 90, 30);
                    default -> {
                    }
                }
            }
        }

        if (circuit instanceof SerialCircuit) {
            switch (checkSource(circuit.getSource())) {
                case 1 ->
                    this.paintElecComponent(g2d, new ACGUI(circuit), 600, 300, 60, 60);
                case 2 ->
                    this.paintElecComponent(g2d, new DCGUI(circuit), 600, 300, 60, 60);
                default -> {
                }
            }
        } else {
            switch (checkSource(circuit.getSource())) {
                case 1 ->
                    this.paintElecComponent(g2d, new ACGUI(circuit), 200, 200, 60, 60);
                case 2 ->
                    this.paintElecComponent(g2d, new DCGUI(circuit), 200, 200, 60, 60);
                default -> {
                }
            }
        }
    }

    public int checkSource(Source src) {
        if (src instanceof AC) {
            return 1;
        }

        return 2;
    }

    public int checkComponent(ElectricalComponent elecComp) {
        if (elecComp instanceof Capacitor) {
            return 1;
        }

        if (elecComp instanceof Resistor) {
            return 2;
        }

        return 3;
    }

    public void paintElecComponent(Graphics2D g2d, ElementGUI eleGUI, int centerX, int centerY, int width, int height) {
        eleGUI.setPosition(centerX, centerY, width, height);
        eleGUI.paintComponent(g2d);
    }
}
