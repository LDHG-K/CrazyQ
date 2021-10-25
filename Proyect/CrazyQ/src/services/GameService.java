package services;

import java.util.Date;
import java.util.List;

import domain.Game;
import repository.GameDao;

public class GameService {

	private GameDao gd;
	
	public GameService(GameDao gd) {
		this.gd = gd;
	}
	
	public boolean createGame(Game g) {
		
		try {
			gd.create(g);
			return true;
		} catch (Exception e) {
			return false;
		}	
	}
	
	
	
	public Object saveGame(Long total, String player) {
		
		Game g = new Game();
		
		g.setPlayerName(player);
		g.setTotalScore(total);
		g.setGameDate(new Date());
		
		createGame(g);
		
		return lastSavedGame();
	}
	
	public Object lastSavedGame() {
		
		try {
			List<Object> l = gd.listAll();
			return  l.get(l.size()-1);
		} catch (Exception e) {
			return null;
			// TODO: handle exception
		}
	}
	
	
	
	
	
	
	
	
}
