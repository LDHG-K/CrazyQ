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
	private PanelConfig panelConfig;
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
		panelConfig = new PanelConfig(this);
		
		
		add(panelTop,BorderLayout.NORTH);
		add(panelOptions,BorderLayout.SOUTH);
		add(panelConfig,BorderLayout.CENTER);
		
		panelConfig.setVisible(false);
	}
	
	public void showConfig(boolean state) {
		
		panelConfig.setVisible(state);
		
	}

	public PanelTop getPanelTop() {
		return panelTop;
	}

	public void setPanelTop(PanelTop panelTop) {
		this.panelTop = panelTop;
	}

	public PanelOptions getPanelOptions() {
		return panelOptions;
	}

	public void setPanelOptions(PanelOptions panelOptions) {
		this.panelOptions = panelOptions;
	}

	public PanelConfig getPanelConfig() {
		return panelConfig;
	}

	public void setPanelConfig(PanelConfig panelConfig) {
		this.panelConfig = panelConfig;
	}
	
	

}
