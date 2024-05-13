
package model.Source;

public abstract class Source {
	private double  voltage;
	private double frequency;
	private String voltageUnit;
	private String frequencyUnit;
	
	public Source() {
		
	}
	public double getVoltage() {
		return this.voltage;
	}
	public double getFrequency() {
		return this.frequency;
	}
	public String getVoltageUnit() {
		return this.voltageUnit;
	}
	public String getFrequencyUnit() {
		return this.frequencyUnit;
	}
	public void setVoltage(double voltage) {
		this.voltage = voltage;
	}
	public void setFrequency(double frequency) {
		this.frequency = frequency;
	}
	public void setVoltageUnit(String voltageUnit) {
		this.voltageUnit = voltageUnit;
	}
	public void setFrequencyUnit(String frequencyUnit) {
		this.frequencyUnit = frequencyUnit;
	}
	public double getNormalizedVol() {
		if (this.voltageUnit == "MV" ) {
			return this.voltage * 1e6;
		}
		else if (this.voltageUnit == "kV") {
			return this.voltage * 1e3;
		}
		else if (this.voltageUnit == "mV") {
			return this.voltage * 1e-3;
		}
		else {
			return this.voltage;
		}
	}
	public double getNormalizedFre() {
		if (this.frequencyUnit == "MHz") {
			return this.frequency * 1e6;
		}
		else if(this.frequencyUnit == "kHz") {
			return this.frequency * 1e3;
		}
		else {
			return this.frequency;
		}
	}
	public abstract String toString();
}
