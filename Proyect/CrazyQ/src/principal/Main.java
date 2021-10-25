package principal;


import javax.swing.UIManager;

import views.Principal;

public class Main {

	public static void main(String[] args) {
		try {
			
			 // Unifica la interfaz para Mac y para Windows.
			
            UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName( ) );
            
            Principal principal = new Principal();
    		principal.setVisible(true);
    		
		} catch (Exception e) {
		}
		
		
	}

}
