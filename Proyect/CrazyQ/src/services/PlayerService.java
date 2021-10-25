package services;

import domain.Player;
import repository.PlayerDao;

public class PlayerService {

	private PlayerDao pd ;
	
	public PlayerService (PlayerDao pd) {
		this.pd =pd;
	}
	
	public Object searchPlayer(String player) {
		Player b = new Player();
		b.setNickname(player);
		
		try {
			
			Object p = pd.read(b);
			if (p==null) {
				return null;
			}
			return p;
		} catch (Exception e) {
			return null;
			// TODO: handle exception
		}
	}
	
	public void updatePlayer(Object player) {
		try {
			pd.update(player);	
		} catch (Exception e) {
			// TODO: handle exception
		}	
	}
	
	public boolean createPlayer (Object player) {
		try {
			pd.create(player);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
 	public void savePlayerStats (String player, Long total) {
 		Player p = (Player) searchPlayer(player);
		
		if (p==null) {
			p.setNickname(player);
			p.setLastScore(total);
			p.setBestScore(total);
			createPlayer(p);
		}
		else
		{
			if (total>p.getBestScore()) {
				p.setBestScore(total);
			}
			p.setLastScore(total);
			updatePlayer(p);
		}
 	}
}
