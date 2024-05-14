package screen;

import javax.swing.DefaultComboBoxModel;

import model.ElectricalComponent.Capacitor;
import model.ElectricalComponent.ElectricalComponent;

public class CapacitorPanel extends ElecCompPanel {
	private static final long serialVersionUID = 1L;

	public CapacitorPanel(Menu menu, int id) {
   	super(menu, id);
		setType("C");
		setName();
		setUnit();
	}
	
	public void setUnit() {
		getComboBox().setModel(new DefaultComboBoxModel<>(new String[] {"F", "mF", "μF", "nF", "pF"}));
	}

	public ElectricalComponent castToElecComp(){
		return new Capacitor(getResistance(), getUnit(), getId());
	}
	
}
