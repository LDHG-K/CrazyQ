package repository;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import domain.Game;
import domain.Player;
import services.Crud;

public class GameDao implements Crud{

	private ConnectionPostgres con;
	
	 public GameDao(ConnectionPostgres con) {
		 this.con = con;
	 }
	
	@Override
	public boolean create(Object obj) {
		
		Game c = (Game) obj;
		try {
			String cad = "INSERT INTO games VALUES ("+c.getIdGame()+",'"+c.getGameDate()+"',"+c.getTotalScore()+","+c.getPlayerName() +")";
			con.executeUpdateStatement(cad);
			con.aceptar();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return false;
	}

	@Override
	public Object read(Object obj) {
		Game c = (Game) obj;
		
		try {
			String cad = "SELECT * FROM games WHERE nickname = "+c.getIdGame();
			ResultSet res = con.executeQueryStatement(cad);
			while(res.next())
            {
				c.setGameDate(res.getDate(1));
				c.setTotalScore(res.getLong(2));
				c.setPlayerName(res.getString(3));
            }
		} catch (Exception e) {
			// TODO: handle exception
		}
		return c;
	}

	@Override
	public boolean update(Object obj) {
		Game c = (Game) obj;
		String cad = "UPDATE games SET game_date = "+ c.getGameDate()
		+" , total_score = "+ c.getTotalScore()
		+" , player_nickname = "+c.getPlayerName()
		+ "WHERE id_game = " + c.getIdGame();
		try {
			if (!con.executeUpdateStatement(cad)) {
		        throw new Exception();
		    }
			con.aceptar();
		} catch (Exception e) {
		
		}

		return true;
	}

	@Override
	public boolean delete(Object obj) {
		Game c = (Game) obj;
		
		String cad = "DELETE FROM games WHERE id_game ="+c.getIdGame();
		
		try {
			if (!con.executeUpdateStatement(cad)) {
				
                throw new Exception();
            }
			con.aceptar();
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

	@Override
	public List<Object> listAll() {
	
		try {
            String cad = "SELECT * FROM games";
            
            ResultSet res;
            List<Object> resp = new ArrayList<Object>();
            
            res = con.executeQueryStatement(cad);
            
            while(res.next()){
            	
            	Game c = new Game();
            	
            	c.setIdGame(res.getLong(0));
            	c.setGameDate(res.getDate(1));
            	c.setTotalScore(res.getLong(2));
            	c.setPlayerName(res.getString(3));
            	
                
                resp.add(c);
            }
            
            return resp;
            
        } catch (Exception ex) {
             return null;
        }
	}

}
