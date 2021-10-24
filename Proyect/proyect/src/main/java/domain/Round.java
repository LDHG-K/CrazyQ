package domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the rounds database table.
 * 
 */
@Entity
@Table(name="rounds")
@NamedQuery(name="Round.findAll", query="SELECT r FROM Round r")
public class Round implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private RoundPK id;

	@Column(name="answer_score")
	private Integer answerScore;

	@Column(name="round_number")
	private Integer roundNumber;

	//bi-directional many-to-one association to Game
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="game_id")
	private Game game;

	//bi-directional many-to-one association to Question
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="questions_id")
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

}