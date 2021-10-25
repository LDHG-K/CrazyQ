package views;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelGame extends JPanel implements ActionListener {
	
	private JButton a; 
	private JButton b;
	private JButton c;
	private JButton d;
	
	public PanelGame (Principal principal) {
		
		setLayout(new GridLayout(2,2));
		
		a = new JButton();
		a.addActionListener(this);
		a.setActionCommand("A");
		b = new JButton();
		b.addActionListener(this);
		b.setActionCommand("B");
		c = new JButton();
		c.addActionListener(this);
		c.setActionCommand("C");
		d = new JButton();
		d.addActionListener(this);
		d.setActionCommand("D");
		
		add(a);
		add(b);
		add(c);
		add(d);
	}
	
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String comando = e.getActionCommand( );

        if( comando.equals( a.getActionCommand()) ) {
            
        }
        else if( comando.equals( b.getActionCommand()) ) {
        	
        }
		else if( comando.equals( c.getActionCommand()) ) {
		        	
		}
		else if( comando.equals( d.getActionCommand()) ) {
			
		}
		
		
	}
	

}
