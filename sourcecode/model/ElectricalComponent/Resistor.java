package model.ElectricalComponent;

public class Resistor extends ElectricalComponent{
	private double resistance;
	
	public Resistor(double resistance, String unit, int id) {
		super.setName("R", id);
		super.setUnit(unit);
		this.resistance = resistance;
	}
	@Override
	public String toString() {
		return  this.getName() + "\n" +
				Double.toString(this.resistance) + " " + this.getUnit() + "\n";
	}
	@Override
	public double getNormalizedParameter() {
		if (this.getUnit() == "mΩ") {
			return this.resistance * 1e-3;
		}
		else if (this.getUnit() == "kΩ") {
			return this.resistance * 1e3;
		}
		else if (this.getUnit() == "MΩ") {
			return this.resistance * 1e6;
		}
		else if (this.getUnit() == "GΩ") {
			return this.resistance * 1e9;
		
		}
		else {
			return this.resistance;
		}
	}
	@Override
	public void CalculateResistance(double frequency ) {
		super.setResistance(this.getNormalizedParameter(), 0);
	}
}
