package views;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelConfig extends JPanel implements ActionListener {

	private JLabel ql;
	private JTextField question;
	
	private JLabel ca;
	private JTextField correctAns;
	
	private JLabel a2;
	private JTextField ans2;
	
	private JLabel a3 ;
	private JTextField ans3;
	
	private JLabel a4;
	private JTextField ans4;
	
	private JLabel cat;
	private JComboBox<Object> categories; 
	
	private JLabel dif;
	private JComboBox<Object> dificulties; 
	
	private JLabel space;
	private JButton add;
	
	public PanelConfig(Principal principal) {
		
		setLayout(new GridLayout(8, 2));
		
		ql = new JLabel("Question :");
		ca = new JLabel("Correct Answer :");
		a2 = new JLabel("Answer 2 :");
		a3 = new JLabel("Answer 3 :");
		a4 = new JLabel("Answer 4 :");
		cat = new JLabel("Category :");
		dif = new JLabel("Dificulty :");
		space = new JLabel();
		
		question = new JTextField();
		correctAns = new JTextField();
		ans2 = new JTextField();
		ans3 = new JTextField();
		ans4 = new JTextField();
		
		categories = new JComboBox<Object>();
		dificulties = new JComboBox<Object>();
		
		add = new JButton("ADD + ");
		add.setActionCommand("A");
		add.addActionListener(this);
		
		add(ql);
		add(question);
		add(ca);
		add(correctAns);
		add(a2);
		add(ans2);
		add(a3);
		add(ans3);
		add(a4);
		add(ans4);
		add(cat);
		add(categories);
		add(dif);
		add(dificulties);
		add(space);
		add(add);
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
