package domain;

import java.io.Serializable;

import java.util.List;




public class Player implements Serializable {
	private static final long serialVersionUID = 1L;

	private String nickname;

	private Long bestScore;

	private Long lastScore;

	
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