package s09_borders;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Toolbar extends JPanel implements ActionListener {

	private JButton helloButton;
	private JButton goodbyeButton;
	private TextPanel textPanel;
	
	private StringListener textListener;
	
	public Toolbar() {
		helloButton = new JButton("Hello");
		goodbyeButton = new JButton("Goodbye");
		
		setBorder(BorderFactory.createEtchedBorder());
		setLayout(new FlowLayout(FlowLayout.LEFT));
		
		helloButton.addActionListener(this);
		goodbyeButton.addActionListener(this);
		
		add(helloButton);
		add(goodbyeButton);
	}
	
	public void setTextPanel(TextPanel textPanel) {
		this.textPanel = textPanel;
	}
	
	public void setTextListener(StringListener textListener) {
		this.textListener = textListener;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton clicked = (JButton) e.getSource();
		
		if (clicked == helloButton) {
			if (textListener != null) {
				textListener.textEmitted("Hello\n");
			}
		}
		
		if (clicked == goodbyeButton) {
			if (textListener != null) {
				textListener.textEmitted("Goodbye\n");
			}
		}
	}
	
}
