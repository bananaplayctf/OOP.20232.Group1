package draw;

import javax.swing.JFrame;
import model.Circuit.*;
import model.ElectricalComponent.Capacitor;
import model.ElectricalComponent.Inductor;
import model.ElectricalComponent.Resistor;
import model.Source.*;
import model.Source.Source;

public class mainFrame extends JFrame {
    private DrawPanel drawPanel;
    private TablePanel tablePanel;
    private Circuit circuit;
    
    public mainFrame(Circuit circuit) {
        this.circuit = circuit;
        circuit.AddElectricalComponent(new Capacitor(50, "mF", 1));
        circuit.AddElectricalComponent(new Resistor(50, "m", 2));
        circuit.AddElectricalComponent(new Inductor(50, "mH", 3));
        circuit.AddElectricalComponent(new Inductor(50, "mH", 4));
        //circuit.AddElectricalComponent(new Inductor(50, "mH", 5));
        
        this.drawPanel = new DrawPanel(circuit);
        this.drawPanel.setBounds(0, 0, 1200, 400);
        this.drawPanel.setComponentPosition();
        
        this.tablePanel = new TablePanel(circuit);
        tablePanel.setBounds(0, 400, 1200, 400);
        tablePanel.showTable();
        
        this.add(drawPanel);
        
        this.add(tablePanel);
        this.setLayout(null);
        this.setSize(1200, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
    public void run(Circuit circuit) {
        new mainFrame(circuit);
    }
}
