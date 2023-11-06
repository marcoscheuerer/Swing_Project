package s02_components;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class MainFrame extends JFrame {

	JButton button;
	JTextArea textArea;
	
	public MainFrame() {
		super("My Simple Window");
		setLayout(new BorderLayout());
		
		button = new JButton("Click Me!!!");
		textArea = new JTextArea();
		
		add(textArea, BorderLayout.CENTER);
		add(button, BorderLayout.SOUTH);
		
		setSize(500, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
