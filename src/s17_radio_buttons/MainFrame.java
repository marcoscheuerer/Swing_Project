package s17_radio_buttons;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class MainFrame extends JFrame {

	private TextPanel textPanel;
	private Toolbar toolbar;
	private FormPanel formPanel;
	
	public MainFrame() {
		super("My Simple Window");
		setLayout(new BorderLayout());
		
		textPanel = new TextPanel();
		toolbar = new Toolbar();
		formPanel = new FormPanel();
		
		toolbar.setStringListener(new StringListener() {
			@Override
			public void textEmitted(String text) {
				textPanel.appendText(text);
			}
		});
		
		formPanel.setFormListener(new FormListener() {
			@Override
			public void formEventOccurred(FormEvent e) {
				String name = e.getName();
				String occupation = e.getOccupation();
				int ageCategory = e.getAgeCategory();
				String employeeCategory = e.getEmployeeCategory();
				String taxId = e.getTaxId();
				boolean isUsCitizen = e.isUsCitizen();
				String gender = e.getGender();
				
				textPanel.appendText(name + ": " + occupation + ": " + ageCategory 
									      + ": " + employeeCategory + ": " + taxId 
									      + ": " + isUsCitizen + ": " + gender + "\n");
			}
		});
				
		toolbar.setTextPanel(textPanel);
		
		add(formPanel, BorderLayout.WEST);
		add(toolbar, BorderLayout.NORTH);
		add(textPanel, BorderLayout.CENTER);
		
		setSize(500, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
