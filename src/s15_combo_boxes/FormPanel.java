package s15_combo_boxes;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class FormPanel extends JPanel {

	private JLabel nameLabel;
	private JLabel occupationLabel;
	private JTextField nameField;
	private JTextField occupationField;
	private JButton okButton;
	private FormListener formListener;
	private JList ageList;
	private JComboBox employeeComboBox;
	
	public FormPanel() {
		Dimension dim = getPreferredSize();
		dim.width = 250;
		setPreferredSize(dim);
		
		nameLabel = new JLabel("Name: ");
		occupationLabel = new JLabel("Occupation: ");
		nameField = new JTextField(10);
		occupationField = new JTextField(10);
		ageList = new JList();
		employeeComboBox = new JComboBox();
		
		// Set up list box
		DefaultListModel ageModel = new DefaultListModel();
		ageModel.addElement(new AgeCategory(0, "Under 18"));
		ageModel.addElement(new AgeCategory(1, "18 to 65"));
		ageModel.addElement(new AgeCategory(2, "65 or over"));
		ageList.setModel(ageModel);
		ageList.setPreferredSize(new Dimension(115, 68));
		ageList.setBorder(BorderFactory.createEtchedBorder());
		ageList.setSelectedIndex(1);
		
		// Set up combo box
		DefaultComboBoxModel employeeModel = new DefaultComboBoxModel();
		employeeModel.addElement("employed");
		employeeModel.addElement("self-employed");
		employeeModel.addElement("unemployed");
		employeeComboBox.setModel(employeeModel);
		employeeComboBox.setSelectedIndex(1);
		employeeComboBox.setEditable(true);
		employeeComboBox.setPreferredSize(new Dimension(125, 25));
		
		okButton = new JButton("OK");
		okButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = nameField.getText();
				String occupation = occupationField.getText();
				AgeCategory ageCategory = (AgeCategory) ageList.getSelectedValue();
				String employeeCategory = (String) employeeComboBox.getSelectedItem();
				
				//System.out.println(ageCategory.getId());
				System.out.println(employeeCategory);
				
				FormEvent event = new FormEvent(this, name, occupation, ageCategory.getId(), employeeCategory);
				
				if (formListener != null) {
					formListener.formEventOccurred(event); 
				}
			}
					
		});
		
		Border innerBorder = BorderFactory.createTitledBorder("Add Person");
		Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
		
		layoutComponents();
	}
		
	public void setFormListener(FormListener formListener) {
		this.formListener = formListener;
	}
	
	public void layoutComponents() {
		setLayout(new GridBagLayout());
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.NONE;
		
		//---------- First row ------------------------------------//
		gbc.gridy = 0;
		
		gbc.weightx = 1;
		gbc.weighty = 0.2;
		
		gbc.gridx = 0;
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.insets = new Insets(0, 0, 0, 5);
		add(nameLabel, gbc);
		
		gbc.gridx = 1;
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.insets = new Insets(0, 0, 0, 0);
		add(nameField, gbc);
	
		//---------- Second row -----------------------------------//
		gbc.gridy++;
		
		gbc.weightx = 1;
		gbc.weighty = 0.2;
	
		gbc.gridx = 0;
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.insets = new Insets(0, 0, 0, 5);
		add(occupationLabel, gbc);
		
		gbc.gridx = 1;
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.insets = new Insets(0, 0, 0, 0);
		add(occupationField, gbc);
		
		//---------- Third row ------------------------------------//
		gbc.gridy++;
		
		gbc.weightx = 1;
		gbc.weighty = 0.2;
		
		gbc.gridx = 0;
		gbc.anchor = GridBagConstraints.FIRST_LINE_END;
		gbc.insets = new Insets(0, 0, 0, 5);
		add(new JLabel("Age: "), gbc);
		
		gbc.gridx = 1;
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		gbc.insets = new Insets(0, 0, 0, 0);
		add(ageList, gbc);
		
		//---------- Fourth row -----------------------------------//
		gbc.gridy++;
		
		gbc.weightx = 1;
		gbc.weighty = 0.2;
		
		gbc.gridx = 0;
		gbc.anchor = GridBagConstraints.FIRST_LINE_END;
		gbc.insets = new Insets(4, 0, 0, 5);
		add(new JLabel("Employment: "), gbc);
		
		gbc.gridx = 1;
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		gbc.insets = new Insets(0, 0, 0, 0);
		add(employeeComboBox, gbc);
		
		//---------- Fifth row ------------------------------------//
		gbc.gridy++;
		gbc.gridx = 1;
		
		gbc.weightx = 1;
		gbc.weighty = 3.4;
		
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		gbc.insets = new Insets(10, 0, 0, 0);
		add(okButton, gbc);
	}
}

class AgeCategory {
	private int id;
	private String text;
	
	public AgeCategory(int id, String text) {
		this.id = id;
		this.text = text;
	}

	@Override
	public String toString() {
		return text;
	}
	
	public int getId() {
		return id;
	}
	
}


