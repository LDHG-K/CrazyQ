package views;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelTop extends JPanel {

	private JLabel topMessage;
	
	private Principal principal;
	
	public PanelTop(Principal principal) {
		
		this.principal = principal;
		
		setLayout(new BorderLayout());
		
		topMessage = new JLabel("\n WELCOME TO CRAZY Q \n");
		topMessage.setHorizontalAlignment(JLabel.CENTER);
		
		add(topMessage, BorderLayout.NORTH);
		
	}
	
	
	public void changeText (String text) {
		topMessage.setText(text);
	}
	
}
