package pl.danielzeliazkow.nordeobetting.db.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "MATCH")
public class Match {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String teamOneName;
	
	private String teamTwoName;
	
//	@Temporal(TemporalType.DATE)
	private LocalDateTime date;
	
	private boolean isfinished;
	
	private Integer teamOneResult;
	
	private Integer teamTwoResult;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTeamOneName() {
		return teamOneName;
	}

	public void setTeamOneName(String teamOneName) {
		this.teamOneName = teamOneName;
	}

	public String getTeamTwoName() {
		return teamTwoName;
	}

	public void setTeamTwoName(String teamTwoName) {
		this.teamTwoName = teamTwoName;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public boolean isIsfinished() {
		return isfinished;
	}

	public void setIsfinished(boolean isfinished) {
		this.isfinished = isfinished;
	}

	public Integer getTeamOneResult() {
		return teamOneResult;
	}

	public void setTeamOneResult(Integer teamOneResult) {
		this.teamOneResult = teamOneResult;
	}

	public Integer getTeamTwoResult() {
		return teamTwoResult;
	}

	public void setTeamTwoResult(Integer teamTwoResult) {
		this.teamTwoResult = teamTwoResult;
	}

}
