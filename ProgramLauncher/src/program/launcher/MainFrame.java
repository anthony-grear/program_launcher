package program.launcher;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Desktop;
import java.io.File;

import javax.swing.*;

public class MainFrame {
	private JFrame frame;
	private JPanel panel1;
	private JLabel label1;
	private JButton button1, button2;
	private String teamsPath = "C:\\Users\\Dell_E5400\\AppData\\Local\\Microsoft\\Teams\\current\\Teams.exe";
	private String notePath = "C:\\Program Files\\Notepad++\\notepad++.exe";
	private String paintPath = "C:\\WINDOWS\\system32\\mspaint.exe";
	private String pdfPath = "C:\\Program Files\\SumatraPDF\\SumatraPDF.exe";
	private String emailPath = "C:\\Program Files (x86)\\Microsoft Office\\root\\Office16\\OUTLOOK.EXE";
	private String snipPath = "C:\\WINDOWS\\system32\\SnippingTool.exe";
	private String chromePath = "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe";
	private String[] pathArr = {teamsPath, notePath, paintPath, pdfPath, emailPath, snipPath,chromePath};
	
	public void createAndShowGUI() {
		initialize();
	}
	
	public void initialize() {
		frame = new JFrame();
		this.frame.setTitle("Program Launcher");
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.setSize(300,185);
		this.frame.setLocation(950,100);
		
		panel1 = new JPanel();
		this.frame.add(panel1);
		
		button1 = new JButton();
		button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					for (int i=0;i<pathArr.length;i++) {
						File file = new File(pathArr[i]);
						if (! Desktop.isDesktopSupported()) {
							System.out.println("Not Supported");
							return;
						}
						if (file.exists()) {
							Desktop desktop = Desktop.getDesktop();
							desktop.open(file);
						}					
					}					
				}				
				catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		this.panel1.add(button1);
		
		button2 = new JButton();
		button2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Runtime rt = Runtime.getRuntime();
					rt.exec("taskkill /F /IM mspaint.exe");
				}
				catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		this.panel1.add(button2);
		
		label1 = new JLabel();
		label1.setText("School Apps Launcher");
		this.button1.add(label1);
		
		
		this.frame.setVisible(true);
	}

}
