package domain;

import java.io.Serializable;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the games database table.
 * 
 */

public class Game implements Serializable {
	private static final long serialVersionUID = 1L;


	private Long idGame;

	
	private Date gameDate;

	private Long totalScore;


	private Player player;

	
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