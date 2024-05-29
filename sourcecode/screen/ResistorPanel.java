package screen;

import javax.swing.DefaultComboBoxModel;

import model.ElectricalComponent.ElectricalComponent;
import model.ElectricalComponent.Resistor;

public class ResistorPanel extends ElecCompPanel{
	private static final long serialVersionUID = 1L;

	public ResistorPanel(Menu menu, int id) {
      super(menu, id);
		setType("R");
		setName();
		setUnit();
	}
	
	public void setUnit() {
		getComboBox().setModel(new DefaultComboBoxModel<>(new String[] {"Ω", "mΩ", "kΩ", "MΩ", "GΩ"}));
	}
	
	public ElectricalComponent castToElecComp(){
		return new Resistor(getResistance(), getUnit(), getId());
	}
	
}
