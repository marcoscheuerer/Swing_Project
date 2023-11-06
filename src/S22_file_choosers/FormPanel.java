package S22_file_choosers;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
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
	private JCheckBox citizenCheckBox;
	private JTextField taxField;
	private JLabel taxLabel;
	
	private JRadioButton maleRadioButton;
	private JRadioButton femaleRadioButton;
	private ButtonGroup genderGroup;
	
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
		citizenCheckBox = new JCheckBox();
		taxField = new JTextField(10);
		taxLabel = new JLabel("Tax ID: ");
		maleRadioButton = new JRadioButton("male");
		femaleRadioButton = new JRadioButton("female");
		genderGroup = new ButtonGroup();
		okButton = new JButton("OK");
		
		// Set up mnemonics
		okButton.setMnemonic(KeyEvent.VK_O);
		nameLabel.setDisplayedMnemonic(KeyEvent.VK_N);
		nameLabel.setLabelFor(nameField);
		
		// Set up gender radio buttons
		maleRadioButton.setSelected(true);
		maleRadioButton.setActionCommand("male");
		femaleRadioButton.setActionCommand("female");
		genderGroup.add(maleRadioButton);
		genderGroup.add(femaleRadioButton);
		
		// Set up tax ID
		taxLabel.setEnabled(false);
		taxField.setEnabled(false);
		
		citizenCheckBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean isTicked = citizenCheckBox.isSelected();
				taxLabel.setEnabled(isTicked);
				taxField.setEnabled(isTicked);
			}
		});
		
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
		
		
		okButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = nameField.getText();
				String occupation = occupationField.getText();
				AgeCategory ageCategory = (AgeCategory) ageList.getSelectedValue();
				String employeeCategory = (String) employeeComboBox.getSelectedItem();
				String taxId = (String) taxField.getText();
				boolean isUsCitizen = (boolean) citizenCheckBox.isSelected();
				
				String gender = genderGroup.getSelection().getActionCommand();
				
				//System.out.println(ageCategory.getId());
				System.out.println(employeeCategory);
				
				FormEvent event = new FormEvent(this, name, occupation, ageCategory.getId(), 
												employeeCategory, taxId, isUsCitizen, gender);
				
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
		
		gbc.weightx = 1;
		gbc.weighty = 0.2;
		
		gbc.gridx = 0;
		gbc.anchor = GridBagConstraints.FIRST_LINE_END;
		gbc.insets = new Insets(2, 0, 0, 5);
		add(new JLabel("US Citizen: "), gbc);
		
		gbc.gridx = 1;
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		gbc.insets = new Insets(0, 0, 0, 0);
		add(citizenCheckBox, gbc);

		//---------- Sixth row ------------------------------------//
		gbc.gridy++;
		
		gbc.weightx = 1;
		gbc.weighty = 0.2;
		
		gbc.gridx = 0;
		gbc.anchor = GridBagConstraints.FIRST_LINE_END;
		gbc.insets = new Insets(2, 0, 0, 5);
		add(taxLabel, gbc);
		
		gbc.gridx = 1;
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		gbc.insets = new Insets(0, 0, 0, 0);
		add(taxField, gbc);

		//---------- Seventh row ------------------------------------//
		gbc.gridy++;
		
		gbc.weightx = 1;
		gbc.weighty = 0.2;
		
		gbc.gridx = 0;
		gbc.anchor = GridBagConstraints.FIRST_LINE_END;
		gbc.insets = new Insets(2, 0, 0, 5);
		add(new JLabel("Gender: "), gbc);
		
		gbc.gridx = 1;
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		gbc.insets = new Insets(0, 0, 0, 0);
		add(maleRadioButton, gbc);

		//---------- Eighth row ------------------------------------//
		gbc.gridy++;
		
		gbc.weightx = 1;
		gbc.weighty = 0.2;
		
		gbc.gridx = 1;
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		gbc.insets = new Insets(-3, 0, 0, 0);
		add(femaleRadioButton, gbc);
				
		//---------- ninth row ----------------------------------//
		gbc.gridy++;
		gbc.gridx = 1;
		
		gbc.weightx = 1;
		gbc.weighty = 2.0;
		
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


