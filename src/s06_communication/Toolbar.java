package s06_communication;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Toolbar extends JPanel implements ActionListener {

	JButton helloButton;
	JButton goodbyeButton;
	TextPanel textPanel;
	
	public Toolbar() {
		helloButton = new JButton("Hello");
		goodbyeButton = new JButton("Goodbye");
		
		setLayout(new FlowLayout(FlowLayout.LEFT));
		
		helloButton.addActionListener(this);
		goodbyeButton.addActionListener(this);
		
		add(helloButton);
		add(goodbyeButton);
	}
	
	public void setTextPanel(TextPanel textPanel) {
		this.textPanel = textPanel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton clicked = (JButton) e.getSource();
		
		if (clicked == helloButton) {
			System.out.println("Hello");
			textPanel.appendText("Hello\n");
		}
		
		if (clicked == goodbyeButton) {
			System.out.println("Goodbye");
			textPanel.appendText("Goodbye\n");
		}
	}
	
}
