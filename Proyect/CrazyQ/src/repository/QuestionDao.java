package repository;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import domain.Category;
import domain.Question;
import services.Crud;

public class QuestionDao implements Crud {

	private ConnectionPostgres con;
	
	public QuestionDao(ConnectionPostgres con ) {
		this.con = con;
	}
	
	
	@Override
	public boolean create(Object obj) {
		Question c = (Question) obj;
		try {
			String cad = "INSERT INTO questions VALUES ("+c.getIdQuestion()+
					",'"+c.getQueston()+
					",'"+c.getAnswer1()+"','"+
					c.getAnswer2()+"','"+
					c.getAnswer3()+"','"+
					c.getAnswer4()+"',"+
					c.getCategoryId()+"',"+
					c.getDificultyId()+")";
					
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
		Question c = (Question) obj;
		try {
			String cad = "SELECT * FROM questions WHERE id_question = "+c.getIdQuestion();
			ResultSet res = con.executeQueryStatement(cad);
			while(res.next())
            {
				c.setQueston(res.getString(0));
				c.setAnswer1(res.getString(1));
				c.setAnswer2(res.getString(2));
				c.setAnswer3(res.getString(3));
				c.setAnswer4(res.getString(4));
				c.setCategoryId(res.getInt(5));
				c.setDificultyId(res.getInt(6));
				
            }
		} catch (Exception e) {
			// TODO: handle exception
		}
		return c;
	}

	@Override
	public boolean update(Object obj) {
		Question c = (Question) obj;
		
		String cad = "UPDATE questions SET queston = '"+ c.getQueston()+"' , ' "+
		"answer_1 = " + c.getAnswer1() +"' , ' "+
		"answer_2 = " + c.getAnswer2() +"' , ' "+
		"answer_3 = " + c.getAnswer3() +"' , ' "+
		"answer_4 = " + c.getAnswer4() +"' ,"+
		"category_id = " + c.getCategoryId() +" , "+
		"dificulty = " + c.getDificultyId()
				+ "WHERE id_question = " + c.getIdQuestion();
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
		Question c = (Question) obj;
		
		String cad = "DELETE FROM questions WHERE id_question ="+c.getIdQuestion();
		
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
            String cad = "SELECT * FROM questions";
            
            ResultSet res;
            List<Object> resp = new ArrayList<Object>();
            
            res = con.executeQueryStatement(cad);
            
            while(res.next()){
            	
            	Question c = new Question();
            	c.setIdQuestion(res.getInt(0));
            	c.setQueston(res.getString(1));
				c.setAnswer1(res.getString(2));
				c.setAnswer2(res.getString(3));
				c.setAnswer3(res.getString(4));
				c.setAnswer4(res.getString(5));
				c.setCategoryId(res.getInt(6));
				c.setDificultyId(res.getInt(7));
                
                resp.add(c);
            }
            
            return resp;
            
        } catch (Exception ex) {
             return null;
        }
	}


	public List<Object> questionByCategory(Category category) {
		try {
            String cad = "SELECT * FROM QUESTIONS WHERE category_id = " + category.getIdCategory();
            
            ResultSet res;
            List<Object> resp = new ArrayList<Object>();
            
            res = con.executeQueryStatement(cad);
            
            while(res.next()){
            	
            	Question c = new Question();
            	c.setIdQuestion(res.getInt(0));
            	c.setQueston(res.getString(1));
				c.setAnswer1(res.getString(2));
				c.setAnswer2(res.getString(3));
				c.setAnswer3(res.getString(4));
				c.setAnswer4(res.getString(5));
				c.setCategoryId(res.getInt(6));
				c.setDificultyId(res.getInt(7));
                
                resp.add(c);
            }
            
            return resp;
            
        } catch (Exception ex) {
             return null;
        }
	}

}
