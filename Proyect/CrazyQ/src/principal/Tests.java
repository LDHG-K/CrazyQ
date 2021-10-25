package principal;

import java.util.List;

import domain.Dificulty;
import domain.Player;
import repository.ConnectionPostgres;
import repository.DificultyDao;
import repository.PlayerDao;

public class Tests {

	public static void main(String[] args) {
		ConnectionPostgres cp = new ConnectionPostgres();
		//PlayerDao pd = new PlayerDao(cp);
		DificultyDao dd = new DificultyDao(cp);
		
		Dificulty d = new Dificulty();
		d.setIdDificultad(1);
		d = (Dificulty) dd.read(d);
		System.out.println(d.getDificulty());
		//Player b = new Player();
		//b.setNickname("LUIS");
				
		//Player p = (Player)pd.read(b);
		
		//System.out.println(
		//p.getNickname());
		
		//List<Object> l = pd.listAll();
		
		//for (Object object : l) {
			
		//	System.out.println(((Player)object).getNickname());
			
		//}
		
		//System.out.println(p.getBestScore());
		//System.out.println(p.getLastScore());

	}

}
