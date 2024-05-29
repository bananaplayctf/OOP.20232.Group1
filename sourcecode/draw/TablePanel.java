package draw;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import model.Circuit.Circuit;
import javax.swing.table.DefaultTableModel;
import model.ElectricalComponent.ElectricalComponent;

public class TablePanel extends JPanel {

    private final JLabel lbl1 = new JLabel("Circuit Analysis Table");
    private final JLabel lbl2 = new JLabel("Equivalent Resistance:");
    private JTable tbl;
    private Circuit circuit;

    public TablePanel() {

    }

    public TablePanel(Circuit circuit) {
        this.circuit = circuit;
    }

    public void setUpTable() {
        DefaultTableModel model = new DefaultTableModel(new Object[][]{}, new String[]{});
        ArrayList<Object[]> elecCompColumns = new ArrayList<>();

        model.addColumn("", new String[]{"", "Voltage", "Current", "Resistance"});

        for (ElectricalComponent elecComp : circuit.getElectricalComponents()) {
            elecCompColumns.add(new String[]{elecComp.getName(), elecComp.getVoltage().toString(), elecComp.getCurrent().toString(), elecComp.getResistance().toString()});
        }

        elecCompColumns.forEach((col) -> model.addColumn(col[0], col));

        model.addColumn("Unit", new String[] {"Unit", "V", "A", "Ω"});

        tbl = new JTable(model);
        tbl.setFont(new Font("Arial", Font.BOLD, 16));
        tbl.setRowHeight(50);
        tbl.setBorder(new LineBorder(Color.GRAY, 1));
        tbl.setBounds(100, 100, this.getWidth() - 200, this.getHeight() - 200);
        tbl.setEnabled(false);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        
        for (int i = 0; i < tbl.getColumnCount(); i++) {
            tbl.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        
        tbl.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
    }

    public void config() {

        lbl1.setBounds(50, 0, 300, 30);
        lbl1.setFont(new Font("Arial", Font.BOLD, 20));

        lbl2.setBounds(50, 350, 1000, 30);
        lbl2.setText(lbl2.getText() + " " + circuit.getEquivalentResistance() + " Ω");
        lbl2.setFont(new Font("Arial", Font.BOLD, 20));
        
        setUpTable();

        this.setLayout(null);
        this.add(lbl1);
        this.add(lbl2);
        this.add(tbl);
    }
}
