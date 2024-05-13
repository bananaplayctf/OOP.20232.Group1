package screen;

import screen.ElecCompPanel;
import screen.Menu;

import javax.swing.DefaultComboBoxModel;

public class CapacitorPanel extends ElecCompPanel {
	private static final long serialVersionUID = 1L;

	public CapacitorPanel(Menu menu, int id) {
   	super(menu, id);
		setName();
		setUnit();
	}
        
   public void setName() {
   	getLabel().setText("C" + getId());
   }
	
	public void setUnit() {
		getComboBox().setModel(new DefaultComboBoxModel<>(new String[] {"F", "mF", "μF", "nF", "pF"}));
	}
	
}
