package domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the dificulties database table.
 * 
 */
@Entity
@Table(name="dificulties")
@NamedQuery(name="Dificulty.findAll", query="SELECT d FROM Dificulty d")
public class Dificulty implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_dificultad")
	private Integer idDificultad;

	private String dificulty;

	@Column(name="dificulty_score")
	private Long dificultyScore;

	//bi-directional many-to-one association to Question
	@OneToMany(mappedBy="dificultyBean")
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