package services;

import java.util.List;

import domain.Question;
import domain.Round;
import repository.RoundDao;

public class RoundServices {

	private RoundDao rd;
	
	public RoundServices(RoundDao rd) {
		this.rd = rd;
	}
	
	public boolean saveRound(List<Long> valDificult, List<Object> questions, Long gameid) {
		
		try {
			int i=0;
			for (Object object : questions) {
				
				Round r = new Round();
				r.setGameId(gameid);
				r.setQuestionId( ((Question) object).getIdQuestion());
				r.setRoundNumber(i+1);
				r.setAnswerScore( valDificult.get(i));
				i++;
				rd.create(r);
			}
			return true;
		} catch (Exception e) {
			return false;
			// TODO: handle exception
		}
		
	}
	
}
