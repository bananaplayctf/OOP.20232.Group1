package model.ElectricalComponent;

public class Capacitor extends ElectricalComponent{
	private double capaciatance;
	
	public Capacitor(double capaciatance, String unit, int id) {
		super.setName("C", id);
		super.setUnit(unit);
		this.capaciatance = capaciatance;
	}
	@Override
	public String toString() {
		return  this.getName() + "\n" +
				Double.toString(this.capaciatance) + " " + this.getUnit() + "\n";
	}
	@Override
	public double getNormalizedParameter() {
		if (this.getUnit() == "mF") {
			return this.capaciatance * 1e-3;
		}
		else if (this.getUnit() == "μF") {
			return this.capaciatance * 1e-6;
		}
		else if (this.getUnit() == "nF") {
			return this.capaciatance * 1e-9;
		}
		else if (this.getUnit() == "pF") {
			return this.capaciatance * 1e-12;
		}
		else {
			return this.capaciatance;
		}
	}
	@Override
	public void CalculateResistance(double frequency ) {
		super.setResistance(0, - 1.0d / (2 * Math.PI * frequency * this.getNormalizedParameter()));
	}
}
