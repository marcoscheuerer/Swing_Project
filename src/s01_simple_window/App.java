package s01_simple_window;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class App {

	private JFrame frame;
	
	public App() {
		frame = new JFrame();
		frame.setTitle("My Simple Window");
		
		frame.setSize(500, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				new App();
			}
			
		});
	}
	
}
