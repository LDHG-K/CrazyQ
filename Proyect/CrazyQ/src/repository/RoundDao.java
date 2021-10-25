package repository;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import domain.Round;
import services.Crud;

public class RoundDao implements Crud{

	private ConnectionPostgres con ;
	
	public RoundDao(ConnectionPostgres con) {
		this.con = con;
	}

	@Override
	public boolean create(Object obj) {
		Round c = (Round) obj;
		try {
			String cad = "INSERT INTO rounds VALUES "+
					"("+c.getGameId()+
					","+c.getQuestionId()+
					","+c.getRoundNumber()+","+
					c.getAnswerScore()+")";
					
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
		Round c = (Round) obj;
		try {
			String cad = "SELECT * FROM rounds WHERE game_id = "+c.getGameId()+" AND questions_id = "+c.getQuestionId();
			ResultSet res = con.executeQueryStatement(cad);
			while(res.next())
            {
				c.setRoundNumber(res.getInt(2));
				c.setAnswerScore(res.getInt(3));
            }
		} catch (Exception e) {
			// TODO: handle exception
		}
		return c;
	}

	@Override
	public boolean update(Object obj) {
		Round c = (Round) obj;
		
		String cad = "UPDATE rounds SET round_number = '"+ c.getRoundNumber()+"'"
				+" , answer_score = "+ c.getAnswerScore()
				+ "WHERE game_id = " + c.getGameId() + " AND " + c.getQuestionId();
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
		Round c = (Round) obj;

		String cad = "DELETE FROM rounds WHERE game_id ="+c.getGameId() + " AND " + " questions_id = "+ c.getQuestionId();
		
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
            String cad = "SELECT * FROM dificulties";
            
            ResultSet res;
            List<Object> resp = new ArrayList<Object>();
            
            res = con.executeQueryStatement(cad);
            
            while(res.next()){
            	
            	Round c = new Round();
                c.setGameId(res.getLong(0));
                c.setQuestionId(res.getInt(1));
                c.setRoundNumber(res.getInt(2));
				c.setAnswerScore(res.getInt(3));
                
                resp.add(c);
            }
            
            return resp;
            
        } catch (Exception ex) {
             return null;
        }
	}
	
	
	
	
}
