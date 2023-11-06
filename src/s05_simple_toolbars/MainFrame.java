package s05_simple_toolbars;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class MainFrame extends JFrame {

	JButton button;
	TextPanel textPanel;
	Toolbar toolbar;
	
	public MainFrame() {
		super("My Simple Window");
		setLayout(new BorderLayout());
		
		button = new JButton("Click Me!!!");
		textPanel = new TextPanel();
		toolbar = new Toolbar();
		
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Hello");
				textPanel.appendText("Hello\n");
			}
		});
		
		add(toolbar, BorderLayout.NORTH);
		add(textPanel, BorderLayout.CENTER);
		add(button, BorderLayout.SOUTH);
		
		setSize(500, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
