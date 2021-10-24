package domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the games database table.
 * 
 */
@Entity
@Table(name="games")
@NamedQuery(name="Game.findAll", query="SELECT g FROM Game g")
public class Game implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_game")
	private Long idGame;

	@Temporal(TemporalType.DATE)
	@Column(name="game_date")
	private Date gameDate;

	@Column(name="total_score")
	private Long totalScore;

	//bi-directional many-to-one association to Player
	@ManyToOne(fetch=FetchType.LAZY)
	private Player player;

	//bi-directional many-to-one association to Round
	@OneToMany(mappedBy="game")
	private List<Round> rounds;

	public Game() {
	}

	public Long getIdGame() {
		return this.idGame;
	}

	public void setIdGame(Long idGame) {
		this.idGame = idGame;
	}

	public Date getGameDate() {
		return this.gameDate;
	}

	public void setGameDate(Date gameDate) {
		this.gameDate = gameDate;
	}

	public Long getTotalScore() {
		return this.totalScore;
	}

	public void setTotalScore(Long totalScore) {
		this.totalScore = totalScore;
	}

	public Player getPlayer() {
		return this.player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public List<Round> getRounds() {
		return this.rounds;
	}

	public void setRounds(List<Round> rounds) {
		this.rounds = rounds;
	}

	public Round addRound(Round round) {
		getRounds().add(round);
		round.setGame(this);

		return round;
	}

	public Round removeRound(Round round) {
		getRounds().remove(round);
		round.setGame(null);

		return round;
	}

}