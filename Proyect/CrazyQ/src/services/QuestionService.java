package services;

import java.util.ArrayList;

import java.util.List;

import domain.Category;
import domain.Question;

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
			
			int[] num = fiveRandomNumbers(res.size());
			
			List<Object> resp = new ArrayList<Object>();
			
			for (int i : num) {
				Object o = res.get(i);
				resp.add(o);
			}
			
			List<Object> questions = orderListByDificult(resp);
			
			return questions;
		} 
			catch (Exception e) {
			return null;
		}
	}
	
	private int[] fiveRandomNumbers(int res) {
		int[] num = new int[5]; 
		
		for (int i : num) {
			num[i]=res+1;
		}
		boolean c = false;
		int j=0;
		
		// Generate 5 different random positions for questions
		while(c) {
			int r = (int) Math.random() * res;
			
			boolean a = true;
			
			for (int i : num) {
				if (i==r) {a = false;}
			}
			
			if (a) {
				num[j]=r;
				j++;
			}
			
		}
		return num;
	}
	
	private List<Object> orderListByDificult(List<Object> list){
		
		
		List<Question> q = new ArrayList<Question>();  
		List<Object> r = new ArrayList<Object>();
		
		for (Object o : list) {
			
			q.add((Question) o);
			
		}
		
		q.sort((o1, o2) -> o1.getDificultyBean().getDificultyScore().compareTo(o2.getDificultyBean().getDificultyScore()));
	
		for (Question question : q) {r.add(question);}
		
		return r;
	}
	
}
