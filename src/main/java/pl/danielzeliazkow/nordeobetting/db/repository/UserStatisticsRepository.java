package pl.danielzeliazkow.nordeobetting.db.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.danielzeliazkow.nordeobetting.db.entity.UserStatistics;

@Repository
public interface UserStatisticsRepository extends JpaRepository<UserStatistics, Integer> {
	
	public List<UserStatistics> findAllByOrderByPointsAsc();

}
