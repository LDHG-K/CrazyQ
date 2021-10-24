package services;

import java.util.List;

public interface Crud {
	
	boolean create(Object obj);
	Object read(Object obj);
	boolean update(Object obj);
	boolean delete(Object obj);
	List<Object> listAll();
	

}
