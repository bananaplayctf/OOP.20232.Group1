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
	private ComplexNumber totalCurrent;
	private ComplexNumber totalResistance;
	
	public Circuit() {
		electricalComponents = new ArrayList<ElectricalComponent>();
	}
	
	public void AddElectricalComponent(ElectricalComponent e) {
		if (totalComponents < MAX_ELEMENTS) {
			electricalComponents.add(e);
			totalComponents += 1;
		}
	}
	public void RemoveElectricalComponent(ElectricalComponent e) {	
	}
	public ComplexNumber getTotalCurrent() {
		return this.totalCurrent;
	}
	public ComplexNumber getTotalResistance() {
		return this.totalResistance;
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
	public void setTotalResistance(ComplexNumber r) {
		this.totalResistance = r;
	}
	public void setTotalCurrent(ComplexNumber i) {
		this.totalCurrent = i;
	}
	public abstract void CalculateTotalCurrent();
	public abstract void CalculateTotalResistance();
	public abstract void CheckShortCircuit();
}
