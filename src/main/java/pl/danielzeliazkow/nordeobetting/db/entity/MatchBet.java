package pl.danielzeliazkow.nordeobetting.db.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Table(name="MATCH_BET")
public class MatchBet {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@ManyToOne
	private Match match;
	
	@ManyToOne
	private Users user;
	
	@Min(0)
	@Max(20)
	private Integer  teamOneScore;
	
	@Min(0)
	@Max(20)
	private Integer  teamTwoScore;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Match getMatch() {
		return match;
	}

	public void setMatch(Match match) {
		this.match = match;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public Integer getTeamOneScore() {
		return teamOneScore;
	}

	public void setTeamOneScore(Integer teamOneScore) {
		this.teamOneScore = teamOneScore;
	}

	public Integer getTeamTwoScore() {
		return teamTwoScore;
	}

	public void setTeamTwoScore(Integer teamTwoScore) {
		this.teamTwoScore = teamTwoScore;
	}
	
	
	
}
