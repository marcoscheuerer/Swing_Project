package s23_filtering_file_choosers;

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
