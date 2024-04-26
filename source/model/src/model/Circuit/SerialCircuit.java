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
	public void CalculateTotalResistance() {
		ComplexNumber res = new ComplexNumber(0, 0);
		for(ElectricalComponent e : this.getElectricalComponents()) {
			res = res.add(e.getResistance());
		}
		this.setTotalResistance(res);
	}
	@Override
	public void CalculateTotalCurrent() {
		this.setTotalCurrent(new ComplexNumber(this.getSource().getNormalizedVol(), 0).divide(getTotalResistance()));
		for(ElectricalComponent e : this.getElectricalComponents()) {
			e.setCurrent(getTotalCurrent().getReal(), getTotalCurrent().getImag());
		}
	}
	@Override
	public void CheckShortCircuit() {
		
	}
}
