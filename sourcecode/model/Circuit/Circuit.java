package model.Circuit;
import java.util.ArrayList;
import model.ElectricalComponent.ElectricalComponent;
import model.Source.Source;
import com.ComplexNumber;

public abstract class Circuit {
	
	private final int MAX_ELEMENTS = 5;
	private int totalComponents;
	private  ArrayList<ElectricalComponent> electricalComponents;
	private Source source;
	private ComplexNumber equivalentResistance;
	
	public Circuit() {
		electricalComponents = new ArrayList<ElectricalComponent>();
	}
	
	public void AddElectricalComponent(ElectricalComponent e) {
		if (totalComponents < MAX_ELEMENTS) {
			electricalComponents.add(e);
			totalComponents += 1;
		}
	}

	public ComplexNumber getEquivalentResistance() {
		return this.equivalentResistance;
	}

	public Source getSource() {
		return this.source;
	}

	public int getTotalComponents() {
		return this.totalComponents;
	}

	public ArrayList<ElectricalComponent> getElectricalComponents(){
		return this.electricalComponents;
	}

	public void setSource(Source src) {
		this.source = src;
	}
	public void setEquivalentResistance(ComplexNumber r) {
		this.equivalentResistance = r;
	}

	public abstract void trigger();
	public abstract void CalculateEquivalentResistance();
	public abstract boolean CheckShortCircuit();
}
