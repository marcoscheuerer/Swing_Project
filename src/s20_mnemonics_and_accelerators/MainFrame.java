package s20_mnemonics_and_accelerators;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

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
		
		setJMenuBar(createMenuBar());
		add(formPanel, BorderLayout.WEST);
		add(toolbar, BorderLayout.NORTH);
		add(textPanel, BorderLayout.CENTER);
		
		setSize(500, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public JMenuBar createMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		
		JMenu fileMenu = new JMenu("File");
		JMenuItem exportDataItem = new JMenuItem("Export Data...");
		JMenuItem importDataItem = new JMenuItem("Import Data...");
		JMenuItem exitItem = new JMenuItem("Exit");
		fileMenu.add(exportDataItem);
		fileMenu.add(importDataItem);
		fileMenu.addSeparator();
		fileMenu.add(exitItem);
		
		JMenu windowMenu = new JMenu("Window");
		JMenu showMenu = new JMenu("Show");
		
		JCheckBoxMenuItem showFormCheckBoxMenuItem = new JCheckBoxMenuItem("Person Form");
		showFormCheckBoxMenuItem.setSelected(true);
		
		showMenu.add(showFormCheckBoxMenuItem);
		windowMenu.add(showMenu);
		
		menuBar.add(fileMenu);
		menuBar.add(windowMenu);
		
		showFormCheckBoxMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				JCheckBoxMenuItem formPanelCheckBoxMenuItem = (JCheckBoxMenuItem)e.getSource();
				
				formPanel.setVisible(formPanelCheckBoxMenuItem.isSelected());
				
			}
		});
		
		fileMenu.setMnemonic(KeyEvent.VK_F);
		exitItem.setMnemonic(KeyEvent.VK_X);
		
		exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
		
		exitItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
			
		});
		
		return menuBar;
	}
}
