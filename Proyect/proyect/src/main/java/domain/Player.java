package domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the players database table.
 * 
 */
@Entity
@Table(name="players")
@NamedQuery(name="Player.findAll", query="SELECT p FROM Player p")
public class Player implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String nickname;

	@Column(name="best_score")
	private Long bestScore;

	@Column(name="last_score")
	private Long lastScore;

	//bi-directional many-to-one association to Game
	@OneToMany(mappedBy="player")
	private List<Game> games;

	public Player() {
	}

	public String getNickname() {
		return this.nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Long getBestScore() {
		return this.bestScore;
	}

	public void setBestScore(Long bestScore) {
		this.bestScore = bestScore;
	}

	public Long getLastScore() {
		return this.lastScore;
	}

	public void setLastScore(Long lastScore) {
		this.lastScore = lastScore;
	}

	public List<Game> getGames() {
		return this.games;
	}

	public void setGames(List<Game> games) {
		this.games = games;
	}

	public Game addGame(Game game) {
		getGames().add(game);
		game.setPlayer(this);

		return game;
	}

	public Game removeGame(Game game) {
		getGames().remove(game);
		game.setPlayer(null);

		return game;
	}

}