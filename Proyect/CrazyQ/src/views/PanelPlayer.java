package views;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import domain.Player;

public class PanelPlayer extends JPanel implements ActionListener {

	private JLabel p;
	private JTextField player;
	private JLabel ls;
	private JLabel lastScore;
	private JLabel bs;
	private JLabel bestScore;
	private JButton search;
	private JLabel space;
	
	private Principal principal;
	
	
	public PanelPlayer (Principal principal) {
		
		this.principal = principal;
		
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
		String comando = e.getActionCommand( );

        if( comando.equals( search.getActionCommand()) ) 
        {
        	Player  p = null;
        	try {
        		p = principal.searchPlayer(player.getText().trim());
        		
        		if (p.getLastScore()==null || p.getBestScore()==null) {
					throw new Exception();
				}
        		else {
        			lastScore.setText(p.getLastScore()+"");
                    bestScore.setText(p.getBestScore()+"");
                    JOptionPane.showMessageDialog( this, "Hello "+ player.getText() + ", ready to play again?", "Good to see u :)", JOptionPane.INFORMATION_MESSAGE );
        		}
			} catch (Exception e2) {
				principal.addPlayer(player.getText().trim());
        		lastScore.setText("0");
            	bestScore.setText("0");
            	JOptionPane.showMessageDialog( this, player.getText() + "in not in DB, but it was created! enjoy the game ", "Added new player", JOptionPane.INFORMATION_MESSAGE );
				
			}
        	
        	
        	
        
        }
		
	}
	
	
}
