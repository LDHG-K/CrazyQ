package domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the rounds database table.
 * 
 */
@Embeddable
public class RoundPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="game_id", insertable=false, updatable=false)
	private Long gameId;

	@Column(name="questions_id", insertable=false, updatable=false)
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