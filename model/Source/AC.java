package model.Source;

public class AC extends Source{
	public AC() {
		
	}
	public AC(double frequency, String freUnit, double voltage, String volUnit) {
		this.setFrequency(frequency);
		this.setFrequencyUnit(freUnit);
		this.setVoltage(voltage);
		this.setVoltageUnit(volUnit);
	}
	
	public String toString() {
		return "AC \n" + Double.toString(getFrequency()) + " " + getFrequencyUnit() + "\n" + Double.toString(getVoltage()) + getVoltageUnit() + "\n";
	}
}
