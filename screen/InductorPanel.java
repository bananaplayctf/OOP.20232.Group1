package screen;

import screen.ElecCompPanel;
import screen.Menu;

import javax.swing.DefaultComboBoxModel;

public class InductorPanel extends ElecCompPanel {
	private static final long serialVersionUID = 1L;
	public InductorPanel(Menu menu, int id) {
      super(menu, id);
		setName();
		setUnit();
	}
        
   public void setName() {
      getLabel().setText("L" + getId());
   }
	
	public void setUnit() {
		getComboBox().setModel(new DefaultComboBoxModel<>(new String[] {"H", "mH", "μH", "nH", "pH"}));
	}
	
}
