package draw;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import model.Circuit.Circuit;
import javax.swing.table.DefaultTableModel;
import model.ElectricalComponent.ElectricalComponent;

public class TablePanel extends JPanel {

    private JTable tbl;
    private Circuit circuit;

    public TablePanel() {

    }

    public TablePanel(Circuit circuit) {
        this.circuit = circuit;
    }

    public void showTable() {
        DefaultTableModel model = new DefaultTableModel(new Object[][]{}, new String[]{});
        ArrayList<Object[]> elecCompColumns = new ArrayList<>();

        model.addColumn("", new String[]{"", "Voltage", "Current", "Resistance"});
        
        for (ElectricalComponent elecComp : circuit.getElectricalComponents()) {
            elecCompColumns.add(new Object[] {elecComp.getName(), elecComp.getVoltage(), elecComp.getCurrent(), elecComp.getResistance()});
        }

        elecCompColumns.forEach((col) -> model.addColumn(col[0], col));

        tbl = new JTable(model);
        tbl.setRowHeight(50);
        tbl.setBorder(new LineBorder(Color.GRAY, 1));
        tbl.setBounds(100, 100, this.getWidth() - 200, this.getHeight() - 200);
        tbl.setEnabled(false);
        
        this.setLayout(null);
        this.add(tbl);
    }
}
