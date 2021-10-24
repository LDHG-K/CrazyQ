package repository;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import domain.Category;
import domain.Dificulty;
import services.Crud;

public class DificultyDao implements Crud{

	private ConnectionPostgres con ;
	
	public DificultyDao(ConnectionPostgres con) {
	this.con = con;
	}
	
	
	@Override
	public boolean create(Object obj) {
		Dificulty c = (Dificulty) obj;
		try {
			String cad = "INSERT INTO Dificulties VALUES ("+c.getIdDificultad()+",'"+c.getDificulty()+"',"+c.getDificultyScore()+")";
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
		Dificulty c = (Dificulty) obj;
		
		try {
			String cad = "SELECT * FROM Dificulties WHERE dificulty = "+c.getDificulty();
			ResultSet res = con.executeQueryStatement(cad);
			while(res.next())
            {
				c.setDificulty(res.getString(2));
				c.setDificultyScore(res.getLong(3));
            }
		} catch (Exception e) {
			// TODO: handle exception
		}
		return c;
	}

	@Override
	public boolean update(Object obj) {
		Dificulty c = (Dificulty) obj;
		String cad = "UPDATE Dificulties SET dificulty = '"+ c.getDificulty()+"'"
				+" , dificulty_score = "+ c.getDificultyScore()
				+ "WHERE id_category = " + c.getIdDificultad();
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
		Dificulty c = (Dificulty) obj;
		
		String cad = "DELETE FROM CATEGORIES WHERE id_dificultad ="+c.getIdDificultad();
		
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
            	
            	Dificulty c = new Dificulty();
                c.setIdDificultad(Integer.parseInt(res.getString(1)));
                c.setDificulty(res.getString(2));
                c.setDificultyScore(res.getLong(3));
                
                resp.add(c);
            }
            
            return resp;
            
        } catch (Exception ex) {
             return null;
        }
		
		
		// TODO Auto-generated method stub
		
	}

	
	
	
	
	
}
