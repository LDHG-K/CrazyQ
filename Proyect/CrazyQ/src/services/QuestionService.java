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
	
	public List<Object> questionsByCategory(Category category){
		
		try {
			
			List <Object> res = qJpa.questionByCategory(category);
			
			return res;
		} 
			catch (Exception e) {
			return null;
		}
	}
	
	
	
	
}
