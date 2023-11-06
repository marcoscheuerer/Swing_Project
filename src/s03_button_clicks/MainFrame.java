package s03_button_clicks;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

import s04_custom_components.TextPanel;

public class MainFrame extends JFrame {

	JButton button;
	TextPanel textPanel;
	
	public MainFrame() {
		super("My Simple Window");
		setLayout(new BorderLayout());
		
		button = new JButton("Click Me!!!");
		textPanel = new TextPanel();
		
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				textPanel.appendText("Hello\n");
			}
		});
		
		add(textPanel, BorderLayout.CENTER);
		add(button, BorderLayout.SOUTH);
		
		setSize(500, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
