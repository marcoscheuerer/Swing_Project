package s26_tables.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.KeyStroke;

import s26_tables.controller.Controller;

public class MainFrame extends JFrame {

	private TextPanel textPanel;
	private Toolbar toolbar;
	private FormPanel formPanel;
	private JFileChooser fileChooser;
	private Controller controller;
	private TablePanel tablePanel;
	
	public MainFrame() {
		super("My Simple Window");
		setLayout(new BorderLayout());
		
		textPanel = new TextPanel();
		toolbar = new Toolbar();
		formPanel = new FormPanel();
		tablePanel = new TablePanel();
		
		controller = new Controller();
		tablePanel.setData(controller.getPeople());
		
		fileChooser = new JFileChooser();
		fileChooser.addChoosableFileFilter(new PersonFileFilter());
		
		toolbar.setStringListener(new StringListener() {
			@Override
			public void textEmitted(String text) {
				textPanel.appendText(text);
			}
		});
		
		formPanel.setFormListener(new FormListener() {
			@Override
			public void formEventOccurred(FormEvent event) {
				/*
				String name = event.getName();
				String occupation = event.getOccupation();
				int ageCategory = event.getAgeCategory();
				String employeeCategory = event.getEmployeeCategory();
				String taxId = event.getTaxId();
				boolean isUsCitizen = event.isUsCitizen();
				String gender = event.getGender();
				
				textPanel.appendText(name + ": " + occupation + ": " + ageCategory 
									      + ": " + employeeCategory 
									      + ": " + taxId 
									      + ": " + isUsCitizen + ": " + gender + "\n");
				*/
				controller.addPerson(event);
				tablePanel.refresh();
			}
		});
				
		toolbar.setTextPanel(textPanel);
		
		setJMenuBar(createMenuBar());
		add(formPanel, BorderLayout.WEST);
		add(toolbar, BorderLayout.NORTH);
		add(tablePanel, BorderLayout.CENTER);
		
		//setResizable(false);
		setMinimumSize(new Dimension(500, 400));
		setSize(600, 500);
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
		
		exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, 
													   ActionEvent.CTRL_MASK));
		
		importDataItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (fileChooser.showOpenDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION) {
					System.out.println(fileChooser.getSelectedFile());
				}
				
			}
			
		});
		
		exportDataItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (fileChooser.showSaveDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION) {
					System.out.println(fileChooser.getSelectedFile());
				}
				
			}
			
		});
		
		exitItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String message = JOptionPane.showInputDialog(MainFrame.this, 
						   "Enter your user name.", 
						   "Enter User Name", 
						   JOptionPane.OK_OPTION | JOptionPane.QUESTION_MESSAGE);
				
				System.out.println(message);
				
				int action = JOptionPane.showConfirmDialog(MainFrame.this, 
														   "Do you really want to exit the application?", 
														   "Confirm Exit", 
														   JOptionPane.OK_CANCEL_OPTION);
				
				if (action == JOptionPane.OK_OPTION)
					System.exit(0);
			}
			
		});
		
		return menuBar;
	}
}
