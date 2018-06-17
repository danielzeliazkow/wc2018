package pl.danielzeliazkow.nordeobetting.db.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name = "USER_STATISTICS")
@Entity
public class UserStatistics {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@OneToOne(mappedBy="userStatistics")
	private Users users;
	
	private int points;
	
	private int goalScoresPredicted;
	
	private int scoresPredicted;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users user) {
		this.users = user;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public int getGoalScoresPredicted() {
		return goalScoresPredicted;
	}

	public void setGoalScoresPredicted(int goalScoresPredicted) {
		this.goalScoresPredicted = goalScoresPredicted;
	}

	public int getScoresPredicted() {
		return scoresPredicted;
	}

	public void setScoresPredicted(int scoresPredicted) {
		this.scoresPredicted = scoresPredicted;
	}
	
	public void addPoints(int value) {
		this.points += value;
	}
	
}
