package domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the questions database table.
 * 
 */
@Entity
@Table(name="questions")
@NamedQuery(name="Question.findAll", query="SELECT q FROM Question q")
public class Question implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_question")
	private Integer idQuestion;

	@Column(name="answer_1")
	private String answer1;

	@Column(name="answer_2")
	private String answer2;

	@Column(name="answer_3")
	private String answer3;

	@Column(name="answer_4")
	private String answer4;

	private String queston;

	//bi-directional many-to-one association to Category
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="category_id")
	private Category category;

	//bi-directional many-to-one association to Dificulty
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="dificulty")
	private Dificulty dificultyBean;

	//bi-directional many-to-one association to Round
	@OneToMany(mappedBy="question")
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

}