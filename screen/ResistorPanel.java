package screen;

import javax.swing.DefaultComboBoxModel;

public class ResistorPanel extends ElecCompPanel{
	private static final long serialVersionUID = 1L;

	public ResistorPanel(Menu menu, int id) {
      super(menu, id);
		setName();
		setUnit();
	}
        
   public void setName() {
      getLabel().setText("R" + getId());
   }
	
	public void setUnit() {
		getComboBox().setModel(new DefaultComboBoxModel<>(new String[] {"Ω", "mΩ", "kΩ", "MΩ", "GΩ"}));
	}
	
}
