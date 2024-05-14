package model.Source;

public class DC extends Source{
	public DC() {
		
	}
	public DC(double voltage, String unit) {
		super();
		this.setVoltage(voltage);
		this.setVoltageUnit(unit);
	}
	
	public String toString() {
		return "DC \n" + Double.toString(getVoltage()) + " " + getVoltageUnit() + "\n";
	}
}
