package s08_size;

import java.awt.Dimension;

import javax.swing.JPanel;

public class FormPanel extends JPanel {

	public FormPanel() {
		Dimension dim = getPreferredSize();
		//System.out.println(dim);
		dim.width = 250;
		setPreferredSize(dim);
	}
	
}
