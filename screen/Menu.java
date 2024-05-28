package screen;

import java.util.ArrayList;

import model.Circuit.*;
import model.Source.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;

import draw.mainFrame;

public class Menu extends JFrame{
	private static final long serialVersionUID = 1L;
	private JComboBox<String> circuitComboBox;
	private JButton helpButton;
	private JLabel sourceLabel;
	private JComboBox<String> sourceComboBox;
	private JLabel sourceNameLabel;
	private JTextField sourceInputTf;
	private JComboBox<String> sourceUnitCb;
	private JLabel frequencyLabel;
	private JTextField frequencyInputTf;
	private JComboBox<String> frequencyUnitCb;
	private JButton addCapacitorButton;
	private JButton addInductorButton;
	private JButton addResistorButton;
	private JButton submitButton;
	private ArrayList<ElecCompPanel> elecPanels;
	
	public Menu() {
		// Create Circuit ComboBox
		circuitComboBox = new JComboBox<String>();
		circuitComboBox.setModel(new DefaultComboBoxModel<>(new String[] { "Parallel Circuit", "Serial Circuit" }));
		circuitComboBox.setBounds(16, 12, 160, 30);
		add(circuitComboBox);
		
		// Create Help Button
		helpButton = new JButton("?");
		helpButton.setBounds(620, 12, 40, 30);
		helpButton.addActionListener( new HelpButtonListener());
		add(helpButton);
		
		// Create Source Label
		sourceLabel = new JLabel("Source");
		sourceLabel.setBounds(22, 90, 50, 25);
		add(sourceLabel);
		
		// Create Source ComboBox
		sourceComboBox = new JComboBox<String>();
		sourceComboBox.setModel(new DefaultComboBoxModel<>(new String[] { "AC", "DC" }));
		sourceComboBox.addItemListener(new SourceListener());
		sourceComboBox.setBounds(80, 90, 93, 25);
		add(sourceComboBox);
		
		// Create Source Name Label
		sourceNameLabel  = new JLabel("AC");
		sourceNameLabel.setBounds(310, 60, 30, 25);
		add(sourceNameLabel);
		
		// Create Source Input TextField
		sourceInputTf = new JTextField();
		sourceInputTf.setEditable(true);
		sourceInputTf.setBounds(300, 90, 160, 25);
		add(sourceInputTf);
		
		// Create Source Unit Input Cb
		sourceUnitCb = new JComboBox<String>();
		sourceUnitCb.setModel(new DefaultComboBoxModel<>(new String[] { "V", "kV", "MV", "GV"}));
		sourceUnitCb.setBounds(500, 90, 80, 25);
		add(sourceUnitCb);
		
		// Create Frequency Label
		frequencyLabel = new JLabel("Frequency");
		frequencyLabel.setBounds(310, 120, 80, 25);
		add(frequencyLabel);
		
		// Create Frequency Input TextField
		frequencyInputTf = new JTextField("");
		frequencyInputTf.setBounds(300, 150, 160, 25);
		add(frequencyInputTf);
		
		// Create Frequency Unit ComboBox
		frequencyUnitCb = new JComboBox<String>();
		frequencyUnitCb.setModel(new DefaultComboBoxModel<>(new String[] {"Hz", "kHz", "MHz", "GHz"}));
		frequencyUnitCb.setBounds(500, 150, 80, 25);
		add(frequencyUnitCb);
		
		// Create Add Buttons
		addCapacitorButton = new JButton("Add Capacitor");
		addCapacitorButton.setBounds(16, 230, 160, 25);
		addCapacitorButton.addActionListener(new AddElecPanelListener());
		add(addCapacitorButton);
		
		addInductorButton = new JButton("Add Inductor");
		addInductorButton.setBounds(16, 300, 160, 25);
		addInductorButton.addActionListener(new AddElecPanelListener());
		add(addInductorButton);
		
		addResistorButton = new JButton("Add Resistor");
		addResistorButton.setBounds(16, 370, 160, 25);
		addResistorButton.addActionListener(new AddElecPanelListener());
		add(addResistorButton);
		
		// Create Submit Button
		submitButton = new JButton("SUBMIT");
		submitButton.setBounds(16, 490, 160, 60);
		submitButton.addActionListener(new SubmitCircuitListner());
		add(submitButton);
		
		// Create Array List of ElecCompPanels
		elecPanels = new ArrayList<>();

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setVisible(true);
		this.setSize(700, 700);
	}
	
	private class SourceListener implements ItemListener{
		@Override
		public void itemStateChanged(ItemEvent e) {
			// TODO Auto-generated method stub
			if (e.getStateChange() == ItemEvent.SELECTED) {
				String item = (String) e.getItem();
				if (item.equals("DC")) {
					sourceNameLabel.setText("DC");
					frequencyLabel.setVisible(false);
					frequencyInputTf.setVisible(false);
					frequencyUnitCb.setVisible(false);
				}
				else {
					sourceNameLabel.setText("AC");
					frequencyLabel.setVisible(true);
					frequencyInputTf.setVisible(true);
					frequencyUnitCb.setVisible(true);
				}
			}
			
		}
		
	}
	
	private class AddElecPanelListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			addButtonActionPerformed(e);
		}
	}

	private class SubmitCircuitListner implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Circuit submittedCircuit = getCircuit();
			submittedCircuit.setSource(getSource());
			addElecCompToCircuit(submittedCircuit);
			mainFrame main = new mainFrame(submittedCircuit);
		}
		
	}

	private class HelpButtonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JFrame frame = new JFrame();
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(300, 200);
			frame.setLayout(new FlowLayout());	
			JTextArea textArea = new JTextArea(10, 50);
			textArea.setText("Bộ không biết dùng hay gì mà hỏi? " +
					"\nTự tìm hiểu đi!" +
					"\nHihi");
			textArea.setFont(new Font("Arial", Font.BOLD, 13));
			textArea.setWrapStyleWord(true);
			textArea.setLineWrap(true);
			textArea.setOpaque(false);
			textArea.setEditable(false);
			textArea.setFocusable(false);
			JScrollPane scrollPane = new JScrollPane(textArea);
			JOptionPane.showMessageDialog(frame, scrollPane, "Help", JOptionPane.INFORMATION_MESSAGE);
		}

	}
        
	public void addButtonActionPerformed(ActionEvent e) {
		if (elecPanels.size() < 5) {
			if (e.getSource() == addCapacitorButton) {
				elecPanels.add(new CapacitorPanel(this, elecPanels.size() + 1));
			} else if (e.getSource() == addInductorButton) {
				elecPanels.add(new InductorPanel(this, elecPanels.size() + 1));
			} else {
				elecPanels.add(new ResistorPanel(this, elecPanels.size() + 1));
			}
				elecPanels.get(elecPanels.size() - 1).setBounds(250, 200 + 70 * (elecPanels.size() - 1), 350, 50);
		}
		else {
			return;
		}
		update();
	}
	
	public Source getSource(){
		if (((String) sourceComboBox.getSelectedItem()).equals("AC")){
			return new AC(Double.parseDouble(frequencyInputTf.getText()), (String) frequencyUnitCb.getSelectedItem(), Double.parseDouble(sourceInputTf.getText()), (String) sourceUnitCb.getSelectedItem());
		}
		else{
			return new DC( Double.parseDouble(sourceInputTf.getText()), (String) sourceUnitCb.getSelectedItem());
		}
	}

	public Circuit getCircuit(){
		if (((String) circuitComboBox.getSelectedItem()).equals("Parallel Circuit")){
			return new ParallelCircuit();
		}
		else{
			return new SerialCircuit();
		}
	}

	public ArrayList<ElecCompPanel> getElecPanels() {
		return elecPanels;
	}

	public void update() {
		this.add(elecPanels.get(elecPanels.size() - 1));
		this.revalidate();
		this.repaint();
	}
	
	public void refresh() {
		for (int i = 0; i < elecPanels.size(); i++) {                
			elecPanels.get(i).setId(i + 1);
			elecPanels.get(i).setName();
			elecPanels.get(i).setBounds(250, 200 + 70 * i, 350, 50);
		}
		revalidate();
		repaint();
	}

	public void addElecCompToCircuit(Circuit circuit){
		for(ElecCompPanel e: elecPanels){
			if (!e.equals(null)) {
				circuit.AddElectricalComponent(e.castToElecComp());
			}
		}
	}
}
