package views;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JFrame;

import controllers.GameController;
import domain.Question;

public class Principal extends JFrame {
	
	private static final long serialVersionUID = 1L;
	//Controllers with logic
	private GameController gameController;
	
	//Panels
	private PanelTop panelTop;
	private PanelOptions panelOptions;
	private PanelConfig panelConfig;
	private PanelGame panelGame;
	private PanelPlayer panelPlayer;
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
		panelGame = new PanelGame(this);
		panelPlayer= new PanelPlayer(this);
		
		add(panelTop,BorderLayout.NORTH);
		add(panelOptions,BorderLayout.SOUTH);
		
		
	}
	
	public void showConfig(boolean state) {
		
		if (state) {
			panelConfig = new PanelConfig(this);
			add(panelConfig,BorderLayout.CENTER);
		}
		else {
			remove(panelConfig);
			repaint();
		}
		
	}
	
	public void showGame(boolean state) {
		
		if (state) {
			panelGame = new PanelGame(this);
			add(panelGame,BorderLayout.CENTER);
		}
		else {
			remove(panelGame);
			repaint();
		}
	}
	
	public void showPlayer(boolean state) {

		if (state) {
			panelPlayer = new PanelPlayer(this);
			add(panelPlayer,BorderLayout.CENTER);
		}
		else {
			remove(panelPlayer);
			repaint();
		}
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
	
	
	public List<Object> listCategories(){
		
		return gameController.getCategories();
	}
	public List<Object> listDificulties(){
		
		return gameController.getDificulties();
	}
	
	public void addQuestion(Question q) {
		
		gameController.createQuestion(q);
	}
	
	
	
	

}
