package program.launcher;



public class ProgramLauncher {

	public static void main(String[] args) throws InterruptedException {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {					
				MainFrame frame = new MainFrame();
				frame.createAndShowGUI();
			}				
		});	

	}

}
