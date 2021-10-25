package services;

import java.util.ArrayList;
import java.util.List;

import domain.Dificulty;
import domain.Question;
import repository.DificultyDao;

public class DificultyService {

	private DificultyDao dd;
	
	public DificultyService(DificultyDao dd) {
		this.dd=dd;
	}
	
	public List<Long> valuesOfQuestions(List<Object> questions ){
		
		List<Long> res = new ArrayList<Long>();
		try {
			
			
			for (Object object : questions) {
				Dificulty d = new Dificulty();
				d.setIdDificultad( ( (Question) object ).getDificultyId() );
				d = (Dificulty) dd.read(d);
				res.add(d.getDificultyScore());
			}
			
			return res;
			
			
		} catch (Exception e) {
			return null;
		}
		
		
	}
	
	
	
}
