package model.Circuit;

import com.ComplexNumber;

import model.ElectricalComponent.ElectricalComponent;
import model.ElectricalComponent.Inductor;
import model.ElectricalComponent.Resistor;
import model.Source.AC;
import model.Source.Source;

public class ParallelCircuit extends Circuit{
	public ParallelCircuit() {
		
	}
	public ParallelCircuit(Source source) {
		super();
		setSource(source);
	}

	@Override
	public void CalculateEquivalentResistance() {
		ComplexNumber invRes = new ComplexNumber(0, 0);
		ComplexNumber unit = new ComplexNumber(1, 0);
		for(ElectricalComponent e : getElectricalComponents()) {
			if (e instanceof Resistor){
				invRes = invRes.add(unit.divide(e.getResistance()));
			}
		}
		if (invRes.equals(new ComplexNumber(0, 0))){
			this.setEquivalentResistance(invRes);
		}
		else{
			this.setEquivalentResistance(unit.divide(invRes));
		}
	}

	@Override
	public boolean CheckShortCircuit() {
		if (getSource() instanceof AC){
			return false;
		}
		for(ElectricalComponent e : getElectricalComponents()){
			if (e instanceof Inductor){
				return true;
			}
		}
		if (this.getEquivalentResistance().equals(new ComplexNumber(0, 0))){
			return true;
		}
		return false;
	}

	@Override
	public void trigger(){
		// Trigger all components
		for(ElectricalComponent e : getElectricalComponents()){
			e.CalculateResistance(getSource().getNormalizedFre());
		}

		// Calculate component's voltage
		ComplexNumber totalVol = new ComplexNumber(getSource().getNormalizedVol(), 0);
		for(ElectricalComponent e : getElectricalComponents()){
			e.setVoltage(totalVol.getReal(), totalVol.getImag());
		}

		// Calculate component's current
		for(ElectricalComponent e : getElectricalComponents()){
			ComplexNumber tempCurrent = totalVol.divide(e.getResistance());
			e.setCurrent(tempCurrent.getReal(), tempCurrent.getImag());
		}

		CalculateEquivalentResistance();
	}
}
