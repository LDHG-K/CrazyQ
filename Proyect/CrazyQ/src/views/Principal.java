package views;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import controllers.GameController;

public class Principal extends JFrame {
	
	private static final long serialVersionUID = 1L;
	//Controllers with logic
	private GameController gameController;
	
	//Panels
	private PanelTop panelTop;
	private PanelOptions panelOptions;
	
	//Components
	
	public Principal() {
	
		gameController = new GameController();
		
		
		//Window properties
		setSize(500,500);
		setTitle("CrazyQ");
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		setResizable( false );
        setLocationRelativeTo( null );
		setLayout(new BorderLayout());
		
		//Panels
		panelTop = new PanelTop(this);
		panelOptions = new PanelOptions(this);
		
		
		add(panelTop,BorderLayout.NORTH);
		add(panelOptions,BorderLayout.SOUTH);
	}
	

}
