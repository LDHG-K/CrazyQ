package domain;

import java.io.Serializable;

import java.util.List;



public class Dificulty implements Serializable {
	private static final long serialVersionUID = 1L;


	private Integer idDificultad;

	private String dificulty;


	private Long dificultyScore;

	private List<Question> questions;

	public Dificulty() {
	}

	public Integer getIdDificultad() {
		return this.idDificultad;
	}

	public void setIdDificultad(Integer idDificultad) {
		this.idDificultad = idDificultad;
	}

	public String getDificulty() {
		return this.dificulty;
	}

	public void setDificulty(String dificulty) {
		this.dificulty = dificulty;
	}

	public Long getDificultyScore() {
		return this.dificultyScore;
	}

	public void setDificultyScore(Long dificultyScore) {
		this.dificultyScore = dificultyScore;
	}

	public List<Question> getQuestions() {
		return this.questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public Question addQuestion(Question question) {
		getQuestions().add(question);
		question.setDificultyBean(this);

		return question;
	}

	public Question removeQuestion(Question question) {
		getQuestions().remove(question);
		question.setDificultyBean(null);

		return question;
	}

}