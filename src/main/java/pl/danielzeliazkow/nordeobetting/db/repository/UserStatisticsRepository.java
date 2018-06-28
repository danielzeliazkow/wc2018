package pl.danielzeliazkow.nordeobetting.db.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pl.danielzeliazkow.nordeobetting.db.entity.MatchBet;
import pl.danielzeliazkow.nordeobetting.db.entity.UserStatistics;

@Repository
public interface UserStatisticsRepository extends JpaRepository<UserStatistics, Integer> {
	
	public List<UserStatistics> findAllByOrderByPointsAsc();
	
	@Query("select us from UserStatistics us where us.users.id = ?1")
	public UserStatistics findStatisticsByUser(int id);

}
