package domain;

import java.io.Serializable;



public class RoundPK implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Long gameId;

	private Integer questionsId;

	public RoundPK() {
	}
	public Long getGameId() {
		return this.gameId;
	}
	public void setGameId(Long gameId) {
		this.gameId = gameId;
	}
	public Integer getQuestionsId() {
		return this.questionsId;
	}
	public void setQuestionsId(Integer questionsId) {
		this.questionsId = questionsId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof RoundPK)) {
			return false;
		}
		RoundPK castOther = (RoundPK)other;
		return 
			this.gameId.equals(castOther.gameId)
			&& this.questionsId.equals(castOther.questionsId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.gameId.hashCode();
		hash = hash * prime + this.questionsId.hashCode();
		
		return hash;
	}
}