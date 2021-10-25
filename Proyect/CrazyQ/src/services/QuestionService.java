package services;

import java.util.List;

import domain.Category;
import domain.Question;
import repository.ConnectionPostgres;
import repository.QuestionDao;

public class QuestionService {

	
	private QuestionDao qJpa;
	
	public QuestionService (QuestionDao qJpa) {
		this.qJpa = qJpa;
		
		
	}
	
	
	public boolean CreateQuestion(Question q) {
		
		try {
			
			qJpa.create(q);
			
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}
	
	public List<Object> questionsByCategory(String category){
		
		try {
			Category cat = new Category();
			cat.setCategoryName(category);
			List <Object> res = qJpa.questionsByCategory(cat);
			
			
			
			
			return res;
		} 
			catch (Exception e) {
			return null;
		}
	}
	
	
	
	
}
