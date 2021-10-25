package views;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import domain.Category;
import domain.Dificulty;
import domain.Question;

public class PanelConfig extends JPanel implements ActionListener {

	private Principal principal;
	
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
		
		this.principal = principal;
		
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
	
		fillcombos();
		
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
	
	
	public void fillcombos() {
	
		List<Object> cat = principal.listCategories();
		
		List<Object> dif = principal.listDificulties();
		
		for (Object object : dif) {
			
			dificulties.addItem(((Dificulty) object ).getDificulty()); 
		}
		
		for (Object object : cat) {
			
			categories.addItem(((Category) object ).getCategoryName()); 
		}
		
		
	}
	
	public int searchIdCategory(String cat ) {
		
		List<Object> cate = principal.listCategories();
		for (Object object : cate) {
			
			if (cat.equals(((Category)object).getCategoryName())) {
				return ((Category)object).getIdCategory();
			}
		}
		return 0;
	}
	public int searchIdDificulty(String cat ) {
		
		List<Object> cate = principal.listDificulties();
		for (Object object : cate) {
			
			if (cat.equals(((Dificulty)object).getDificulty())) {
				return ((Dificulty)object).getIdDificultad();
			}
		}
		return 0;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String comando = e.getActionCommand( );

        if( comando.equals( add.getActionCommand()) ) 
        {
        	Question q = new Question();
        	q.setQueston(question.getText());
        	q.setAnswer1(correctAns.getText());
        	q.setAnswer2(ans2.getText());
        	q.setAnswer3(ans3.getText());
        	q.setAnswer4(ans4.getText());
        	q.setCategoryId( searchIdCategory( (String) categories.getSelectedItem()));
        	q.setDificultyId( searchIdDificulty( (String) dificulties.getSelectedItem()));
        	principal.addQuestion(q);
        }
	}

	
	
}
