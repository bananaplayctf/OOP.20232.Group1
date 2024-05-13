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
	public void CalculateTotalResistance() {
		for(ElectricalComponent e : getElectricalComponents()) {
			e.setVoltage(this.getSource().getNormalizedVol(), 0);
			e.CalculateResistance(this.getSource().getNormalizedFre());
		}
		ComplexNumber invRes = new ComplexNumber(0, 0);
		ComplexNumber temp = new ComplexNumber(1, 0);
		for(ElectricalComponent e : getElectricalComponents()) {
			invRes = invRes.add(temp.divide(e.getResistance()));
		}
		this.setTotalResistance(temp.divide(invRes));
	}
	@Override
	public void CalculateTotalCurrent() {
		
	}
	@Override
	public void CheckShortCircuit() {
		
	}
}
