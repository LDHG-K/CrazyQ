package repository;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import domain.Player;
import services.Crud;

public class PlayerDao implements Crud {

	private ConnectionPostgres con;
	
	public PlayerDao(ConnectionPostgres con) {
		this.con = con;
		}
	
	
	@Override
	public boolean create(Object obj) {
		Player c = (Player) obj;
		try {
			String cad = "INSERT INTO players VALUES ('"+c.getNickname()+"',"+c.getLastScore()+","+c.getBestScore()+")";
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
		Player c = (Player) obj;
		try {
			String cad = "SELECT * FROM players WHERE nickname = "+c.getNickname();
			ResultSet res = con.executeQueryStatement(cad);
			while(res.next())
            {
				c.setLastScore(res.getLong(1));
				c.setBestScore(res.getLong(2));
            }
		} catch (Exception e) {
			// TODO: handle exception
		}
		return c;
	}

	@Override
	public boolean update(Object obj) {
		Player c = (Player) obj;
		String cad = "UPDATE players SET last_score = "+ c.getLastScore()
				+" , best_score = "+ c.getBestScore()
				+ "WHERE nickname = " + c.getNickname();
		try {
			if (!con.executeUpdateStatement(cad)) {
                throw new Exception();
            }
			con.aceptar();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return true;
	}

	@Override
	public boolean delete(Object obj) {
		Player c = (Player) obj;
		String cad = "DELETE FROM players WHERE nickname ="+c.getNickname();
		
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
            String cad = "SELECT * FROM players";
            
            ResultSet res;
            List<Object> resp = new ArrayList<Object>();
            
            res = con.executeQueryStatement(cad);
            
            while(res.next()){
            	
            	Player c = new Player();
            	
            	c.setNickname(res.getString(0));
            	c.setLastScore(res.getLong(1));
            	c.setBestScore(res.getLong(2));
            	
                
                resp.add(c);
            }
            
            return resp;
            
        } catch (Exception ex) {
             return null;
        }
	}

}
