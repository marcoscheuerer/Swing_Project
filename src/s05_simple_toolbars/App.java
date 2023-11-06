package s05_simple_toolbars;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class App {
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				new MainFrame();
			}
			
		});
	}
	
}
