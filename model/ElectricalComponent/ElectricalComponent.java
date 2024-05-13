package model.ElectricalComponent;
import com.ComplexNumber;

public abstract class ElectricalComponent {
	private String name;
	private ComplexNumber voltage;
	private ComplexNumber current;
	private ComplexNumber resistance;
	private String unit;
	
	public ElectricalComponent() {		
	}
	public String getName() {
		return name;
	}
	public ComplexNumber getVoltage() {
		return voltage;
	}
	public ComplexNumber getCurrent() {
		return current;
	}
	public ComplexNumber getResistance() {
		return resistance;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public void setName(String type, int id) {
		this.name = type + Integer.toString(id);
	}
	public void setResistance(double real, double imag) {
		this.resistance = new ComplexNumber(real, imag);
	}
	public void setVoltage(double real, double imag) {
		this.voltage = new ComplexNumber(real, imag);
	}
	public void setCurrent(double real, double imag) {
		this.current = new ComplexNumber(real, imag);
	}
	public void CalculateVoltage() {
		this.voltage = this.current.multiply(this.resistance);
	}
	public void CalculateCurrent() {
		this.current = this.voltage.divide(this.resistance);
	}
	public abstract double getNormalizedParameter();
	public abstract void CalculateResistance(double frequency);
	public abstract String toString();
}
