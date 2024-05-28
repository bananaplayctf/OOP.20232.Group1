package model.Circuit;

import com.ComplexNumber;

import model.ElectricalComponent.ElectricalComponent;
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
		ComplexNumber temp = new ComplexNumber(1, 0);
		for(ElectricalComponent e : getElectricalComponents()) {
			invRes = invRes.add(temp.divide(e.getResistance()));
		}
		this.setEquivalentResistance(temp.divide(invRes));
	}

	@Override
	public void CheckShortCircuit() {
		
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
