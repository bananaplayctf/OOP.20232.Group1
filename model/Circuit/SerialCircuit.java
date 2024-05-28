package model.Circuit;

import com.ComplexNumber;

import model.ElectricalComponent.ElectricalComponent;
import model.Source.Source;

public class SerialCircuit extends Circuit{
	public SerialCircuit() {
		
	}

	public SerialCircuit(Source source) {
		super();
		setSource(getSource());
	}

	@Override
	public void CalculateEquivalentResistance() {
		ComplexNumber res = new ComplexNumber(0, 0);
		for(ElectricalComponent e : this.getElectricalComponents()) {
			res = res.add(e.getResistance());
		}
		this.setEquivalentResistance(res);
	}
	
	@Override
	public boolean CheckShortCircuit() {
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

		CalculateEquivalentResistance();
		
		// Calculate component's current
		ComplexNumber comCurrent = new ComplexNumber(getSource().getNormalizedVol(), 0).divide(getEquivalentResistance());
		for(ElectricalComponent e : getElectricalComponents()){
			e.setCurrent(comCurrent.getReal(), comCurrent.getImag());
		}

		// Calculate component's volatge
		for(ElectricalComponent e : getElectricalComponents()){
			ComplexNumber tempVol = e.getCurrent().multiply(e.getResistance());
			e.setVoltage(tempVol.getReal(), tempVol.getImag());
		}
	}
}
