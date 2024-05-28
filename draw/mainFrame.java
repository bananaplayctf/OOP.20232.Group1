package draw;

import javax.swing.JFrame;
import model.Circuit.Circuit;


public class mainFrame extends JFrame {
    private DrawPanel drawPanel;
    private TablePanel tablePanel;
    private Circuit circuit;
    
    public mainFrame(Circuit circuit) {
        this.circuit = circuit;
        circuit.trigger();
        
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
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }

}

