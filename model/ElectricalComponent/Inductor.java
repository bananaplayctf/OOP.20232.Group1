package model.ElectricalComponent;

public class Inductor extends ElectricalComponent {
	private double inductance;
	
	public Inductor(double inductance, String unit, int id) {
		super.setName("L", id);
		super.setUnit(unit);
		this.inductance = inductance;
	}	
	@Override
	public String toString() {
		return  this.getName() + "\n" +
				Double.toString(this.inductance) + " " + this.getUnit() + "\n";
	}
	@Override
	public double getNormalizedParameter() {
		if (this.getUnit() == "mH") {
			return this.inductance * 1e-3;
		}
		else if (this.getUnit() == "µH") {
			return this.inductance * 1e-6;
		}
		else if (this.getUnit() == "nH") {
			return this.inductance * 1e-9;
		}
		else if (this.getUnit() == "pH") {
			return this.inductance * 1e-12;
		}
		else {
			return this.inductance;
		}
	}
	@Override
	public void CalculateResistance(double frequency ) {
		super.setResistance(0, 2 * Math.PI * frequency * this.getNormalizedParameter());
	}
}
