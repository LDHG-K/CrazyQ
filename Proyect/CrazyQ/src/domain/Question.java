package domain;

import java.io.Serializable;

import java.util.List;



public class Question implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer idQuestion;

	private String answer1;

	private String answer2;

	private String answer3;

	private String answer4;

	private String queston;
	
	private Integer categoryId;
	
	private Integer dificultyId;


	private Category category;

	private Dificulty dificultyBean;

	private List<Round> rounds;

	public Question() {
	}

	public Integer getIdQuestion() {
		return this.idQuestion;
	}

	public void setIdQuestion(Integer idQuestion) {
		this.idQuestion = idQuestion;
	}

	public String getAnswer1() {
		return this.answer1;
	}

	public void setAnswer1(String answer1) {
		this.answer1 = answer1;
	}

	public String getAnswer2() {
		return this.answer2;
	}

	public void setAnswer2(String answer2) {
		this.answer2 = answer2;
	}

	public String getAnswer3() {
		return this.answer3;
	}

	public void setAnswer3(String answer3) {
		this.answer3 = answer3;
	}

	public String getAnswer4() {
		return this.answer4;
	}

	public void setAnswer4(String answer4) {
		this.answer4 = answer4;
	}

	public String getQueston() {
		return this.queston;
	}

	public void setQueston(String queston) {
		this.queston = queston;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Dificulty getDificultyBean() {
		return this.dificultyBean;
	}

	public void setDificultyBean(Dificulty dificultyBean) {
		this.dificultyBean = dificultyBean;
	}

	public List<Round> getRounds() {
		return this.rounds;
	}

	public void setRounds(List<Round> rounds) {
		this.rounds = rounds;
	}

	public Round addRound(Round round) {
		getRounds().add(round);
		round.setQuestion(this);

		return round;
	}

	public Round removeRound(Round round) {
		getRounds().remove(round);
		round.setQuestion(null);

		return round;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public Integer getDificultyId() {
		return dificultyId;
	}

	public void setDificultyId(Integer dificultyId) {
		this.dificultyId = dificultyId;
	}

	
	
}