package views;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelOptions extends JPanel implements ActionListener {

	private boolean qcent = true;
	private boolean pcent = false;
	private boolean gcent = false;
	
	private JButton player;
	private JButton questions;
	private JButton game;
	
	
	private Principal principal;
	
	public PanelOptions (Principal principal) {
		
		this.principal = principal;
		
		player = new JButton("Player");
		player.setActionCommand("P");
		player.addActionListener(this);
		
		questions = new JButton("Questions");
		questions.setActionCommand("Q");
		questions.addActionListener(this);
		
		game = new JButton("Start Game");
		game.setActionCommand("G");
		game.addActionListener(this);
			
		setLayout(new GridLayout(1,3));
		
		add(player);
		add(game);
		add(questions);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String comando = e.getActionCommand( );

        if( comando.equals( player.getActionCommand()) ) 
        {
            
        	
        	
        }
        else if( comando.equals( game.getActionCommand() ) )
        {
        	
        	
        	
        }
        else if( comando.equals( questions.getActionCommand() ) )
        {
        	if (qcent==true) {
        		principal.getPanelTop().changeText("¡Add a new Question to your game!");
        	}
        	else {
        		principal.getPanelTop().changeText("¡CrazyQ!");
    		}
        	principal.showConfig(qcent);
        	
        	qcent = !qcent;
        	
        	
        }
        
		
	}
	
}
