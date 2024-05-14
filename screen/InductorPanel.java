package screen;

import javax.swing.DefaultComboBoxModel;

import model.ElectricalComponent.ElectricalComponent;
import model.ElectricalComponent.Inductor;

public class InductorPanel extends ElecCompPanel {
	private static final long serialVersionUID = 1L;
	public InductorPanel(Menu menu, int id) {
      	super(menu, id);
		setType("L");
		setName();
		setUnit();
	}
	
	public void setUnit() {
		getComboBox().setModel(new DefaultComboBoxModel<>(new String[] {"H", "mH", "μH", "nH", "pH"}));
	}

	public ElectricalComponent castToElecComp(){
		return new Inductor(getResistance(), getUnit(), getId());
	}
	
}
