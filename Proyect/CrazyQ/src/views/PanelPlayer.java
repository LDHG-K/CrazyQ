package views;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelPlayer extends JPanel implements ActionListener {

	private JLabel p;
	private JTextField player;
	private JLabel ls;
	private JLabel lastScore;
	private JLabel bs;
	private JLabel bestScore;
	private JButton search;
	private JLabel space;
	
	
	
	public PanelPlayer (Principal principal) {
		
		setLayout(new GridLayout(4,2));
		
		p = new JLabel("Player :");
		player = new JTextField();
		ls = new JLabel("Last Score :");
		lastScore = new JLabel("");
		bs = new JLabel("Best Score :");
		bestScore = new JLabel("");
		space = new JLabel();
		search = new JButton("Search!");
		search.addActionListener(this);
		search.setActionCommand("S");
		
		add(p);
		add(player);
		add(ls);
		add(bs);
		add(lastScore);
		add(bestScore);
		add(space);
		add(search);
		
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
