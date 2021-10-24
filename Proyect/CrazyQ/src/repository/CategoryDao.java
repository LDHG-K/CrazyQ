package repository;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import domain.Category;
import services.Crud;

public class CategoryDao implements Crud {

	private ConnectionPostgres con;
	
	public CategoryDao (ConnectionPostgres con) {
		this.con = con;
	}
	
	
	@Override
	public boolean create(Object obj) {
		
		Category c = (Category) obj;
		try {
			String cad = "INSERT INTO CATEGORIES VALUES ("+c.getIdCategory()+",'"+c.getCategoryName()+"')";
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
		
		Category c = (Category) obj;
		
		try {
			String cad = "SELECT * FROM CATEGORIES WHERE category_name = "+c.getCategoryName();
			ResultSet res = con.executeQueryStatement(cad);
			while(res.next())
            {
				c.setCategoryName(res.getString(2));
            }
		} catch (Exception e) {
			// TODO: handle exception
		}
		return c;
	}

	@Override
	public boolean update(Object obj) {
		Category c = (Category) obj;
		
		String cad = "UPDATE CATEGORIES SET category_name = '"+ c.getCategoryName()+"'"
				+ "WHERE id_category = " + c.getIdCategory();
		
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
		Category c = (Category) obj;
		
		String cad = "DELETE FROM CATEGORIES WHERE id_category ="+c.getIdCategory();
		
		try {
			if (!con.executeUpdateStatement(cad)) {
                throw new Exception();
            }
			con.aceptar();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return false;
	}

	@Override
	public List<Object> listAll() {
		try {
            String cad = "SELECT * FROM CATEGORIES";
            
            ResultSet res;
            List<Object> resp = new ArrayList<Object>();
            
            res = con.executeQueryStatement(cad);
            
            while(res.next()){
            	
            	Category c = new Category();
                c.setIdCategory(Integer.parseInt(res.getString(1)));
                c.setCategoryName(res.getString(2));
                
                resp.add(c);
            }
            
            return resp;
            
        } catch (Exception ex) {
             return null;
        }
		
		
		// TODO Auto-generated method stub
		
	}

}
