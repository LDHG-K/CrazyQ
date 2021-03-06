package controllers;

import java.util.List;

import domain.Game;
import domain.Player;
import domain.Question;
import repository.CategoryDao;
import repository.ConnectionPostgres;
import repository.DificultyDao;
import repository.GameDao;
import repository.PlayerDao;
import repository.QuestionDao;
import repository.RoundDao;
import services.CategoryService;
import services.DificultyService;
import services.GameService;
import services.PlayerService;
import services.QuestionService;
import services.RoundServices;

public class GameController {

	private final ConnectionPostgres con = new ConnectionPostgres();
	private final CategoryDao catdao = new CategoryDao(con);
	private final DificultyDao difdao = new DificultyDao(con);
	private final GameDao gamdao = new GameDao(con);
	private final PlayerDao pladao = new PlayerDao(con);
	private final QuestionDao quedao = new QuestionDao(con);
	private final RoundDao roudao = new RoundDao(con);
	
	private PlayerService plas;
	private GameService gams;
	private RoundServices rous;
	private DificultyService difs;
	private QuestionService ques;
	private CategoryService cats;
	
	public GameController() {
		
		plas = new PlayerService(pladao);
		gams = new GameService(gamdao);
		rous = new RoundServices(roudao);
		difs = new DificultyService(difdao);
		ques = new QuestionService(quedao);
		cats = new CategoryService(catdao);
	}

	/**
	 * Saves the game at the end of it or if is it forced
	 * @param player who played the game
	 * @param AnsweredQuestions questions in order that the player answered
	 * @param totalScore total score that player did in game
	 */
	public void saveGame(String player, List<Object> AnsweredQuestions , long totalScore) {
		//Save player
		plas.savePlayerStats(player, totalScore);
		//Save game
		Object last = gams.saveGame(totalScore, player);
		//Save round
		rous.saveRound(difs.valuesOfQuestions(AnsweredQuestions),
						AnsweredQuestions,
							((Game)last).getIdGame());
		
	}
	
	/**
	 * get 5 questions from a category ordered asc by dificulty score
	 * @return list of 5 questions 
	 */
	public List<Object> getQuestions(String dificulty){
		try {
			return ques.questionsByCategory(dificulty);
		} catch (Exception e) {
			return null;
		}
	}
	
	/**
	 * get the list of dificulties
	 * @return
	 */
	public List<Object> getDificulties(){
		try {
			return difs.listOfDificulties();
		} catch (Exception e) {
			return null;
		}
	}
	
	/**
	 * get the list of categories
	 * @return
	 */
	public List<Object> getCategories(){
		try {
			return cats.listCategories();
		} catch (Exception e) {
			return null;
		}
	}
	
	/**
	 * Creates a question
	 * @param q
	 */
	public void createQuestion(Question q) {
		try {
			ques.CreateQuestion(q);
		} catch (Exception e) {
			
		}
	}
	
	public Object SearchPlayer(String player) {
		try {
			Object o = plas.searchPlayer(player);
			if (o==null) {
				return null;
			}
			return o;
		} catch (Exception e) {
			return null;
			// TODO: handle exception
		}
	}

	public void addPlayer(String player) {
		Player p = new Player();
		p.setNickname(player);
		p.setBestScore(Long.parseLong("0"));
		p.setLastScore(Long.parseLong("0"));
		try {
			plas.createPlayer(p);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	
	
	
}
