package test;

import com.ComplexNumber;
import model.Circuit.*;
import model.ElectricalComponent.*;
import model.Source.*;
import java.util.Scanner;

public class Tester {
	public  Scanner cin;
	public Tester() {
		cin = new Scanner(System.in);
	}
	public  Circuit CircuitOption() {
		System.out.println("1. Parallel Circuit");
		System.out.println("2. Serial Circuit");
		System.out.println("-> What is your choice?");
		int type = this.cin.nextInt();
		if (type == 1) {
			return new ParallelCircuit();
		}
		else {
			return new SerialCircuit();
		}
	}
	public  Source SourceOption() {
		System.out.println("1. AC");
		System.out.println("2. DC");
		System.out.println("-> What is your choice?");
		int type = cin.nextInt();
		return SourceInput(type);
	}
	private  Source SourceInput(int type) {
		System.out.println("-> Enter voltage:");
		double voltage = cin.nextDouble();
		System.out.println("-> Enter voltage unit:");
		String volUnit = cin.next();
		if (type == 1) {
			System.out.println("-> Enter frequency:");
			double frequency = cin.nextDouble();
			System.out.println("-> Enter frequency unit:");
			String freUnit = cin.next();
			return new AC(frequency, freUnit, voltage, volUnit);
			
		}
		else {
			return new DC(voltage, volUnit);
		}
	}
	public void addComponents(Circuit circuit) {
		int cnt = 0;
		while (true) {
			System.out.println("1. Add a new electrical component");
			System.out.println("2. Submit circuit");
			int option = this.cin.nextInt();
			if (option == 1) {
				cnt += 1;
				if (cnt > 5) {
					System.out.println("Error!!!");
				}
				else {
					circuit.AddElectricalComponent(ElectricalComponentInput(circuit.getTotalComponents() + 1));
				}
			}
			else {
				System.out.println("Start simulating........");
				this.Simulating(circuit);
				break;
			}
		}
	}
	private void Simulating(Circuit circuit) {
		System.out.println("This is your circuit!!!");
		for(ElectricalComponent e : circuit.getElectricalComponents()) {
			System.out.println(e.toString());
		}
		
	}
	private ElectricalComponent ElectricalComponentInput(int id) {
		System.out.println("1. Resistor");
		System.out.println("2. Capacitor");
		System.out.println("3. Inductor");
		int option = this.cin.nextInt();
		double resistance;
		String unit;
		if (option == 1) {
			System.out.println("-> Enter resistance:");
			resistance = this.cin.nextDouble();
			System.out.println("-> Enter unit");
			unit = this.cin.next();
			return new Resistor(resistance, unit, id);
		}
		else if (option == 2) {
			System.out.println("-> Enter capacitance:");
			resistance = this.cin.nextDouble();
			System.out.println("-> Enter unit");
			unit = this.cin.next();
			return new Capacitor(resistance, unit, id);
		}
		else {
			System.out.println("-> Enter inductance:");
			resistance = this.cin.nextDouble();
			System.out.println("-> Enter unit");
			unit = this.cin.next();
			return new Inductor(resistance, unit, id);
		} 
	}
	public static void main(String[] args) {
		Tester test = new Tester();
		System.out.println("Welcome to my stupid Circuit Simulator");
		while (true) {
			System.out.println("1. Making your circuit");
			System.out.println("2. Exit");
			if (test.cin.nextInt() == 2) {
				System.out.println("Paaa poiiiiiiiii");
				break;
			}
			else {
				Circuit circuit = test.CircuitOption();
				Source source = test.SourceOption();
				circuit.setSource(source);
				test.addComponents(circuit);
			}
		}
	}
}
