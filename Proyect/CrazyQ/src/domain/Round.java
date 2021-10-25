package domain;

import java.io.Serializable;




public class Round implements Serializable {
	private static final long serialVersionUID = 1L;


	private RoundPK id;

	private Long gameId;
	
	private Integer questionId;
	
	private Integer answerScore;

	private Integer roundNumber;


	private Game game;


	private Question question;

	public Round() {
	}

	public RoundPK getId() {
		return this.id;
	}

	public void setId(RoundPK id) {
		this.id = id;
	}

	public Integer getAnswerScore() {
		return this.answerScore;
	}

	public void setAnswerScore(Integer answerScore) {
		this.answerScore = answerScore;
	}

	public Integer getRoundNumber() {
		return this.roundNumber;
	}

	public void setRoundNumber(Integer roundNumber) {
		this.roundNumber = roundNumber;
	}

	public Game getGame() {
		return this.game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public Question getQuestion() {
		return this.question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public Long getGameId() {
		return gameId;
	}

	public void setGameId(Long gameId) {
		this.gameId = gameId;
	}

	public Integer getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}

	
	
}