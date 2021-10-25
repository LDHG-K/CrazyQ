package services;

import java.util.List;

import repository.CategoryDao;

public class CategoryService {

	private CategoryDao cd;
	
	public CategoryService(CategoryDao cd) {
		this.cd = cd;
	}
	
	public List<Object> listCategories(){
		
		try {
			return cd.listAll();
		} catch (Exception e) {
			return null;
			// TODO: handle exception
		}
		
	}
	
}
