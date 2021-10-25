package views;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelOptions extends JPanel implements ActionListener {

	private JButton player;
	private JButton questions;
	private JButton game;
	
	
	private Principal principal;
	
	public PanelOptions (Principal principal) {
		
		this.principal = principal;
		
		player = new JButton("Player");
		questions = new JButton("Questions");
		game = new JButton("Start Game");
	
		setLayout(new GridLayout(1,3));
		
		add(player);
		add(game);
		add(questions);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
