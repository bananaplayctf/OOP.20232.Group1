package draw;

import javax.swing.JFrame;
import model.Circuit.Circuit;


public class AnalysisFrame extends JFrame {
    private DrawPanel drawPanel;
    private TablePanel tablePanel;
    
    public AnalysisFrame(Circuit circuit) {
        this.drawPanel = new DrawPanel(circuit);
        drawPanel.setBounds(0, 0, 1200, 400);
        drawPanel.config();
        
        this.tablePanel = new TablePanel(circuit);
        tablePanel.setBounds(0, 400, 1200, 400);
        tablePanel.config();
        
        this.add(drawPanel); 
        this.add(tablePanel);

        this.setLayout(null);
        this.setSize(1200, 800);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }

}

