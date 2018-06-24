package pl.danielzeliazkow.nordeobetting.db.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pl.danielzeliazkow.nordeobetting.db.entity.Match;
import pl.danielzeliazkow.nordeobetting.db.entity.MatchBet;

public interface MatchRepository extends JpaRepository<Match, Integer>{
	
	@Query("select m from Match m where m.isfinished = true")
	public List<Match> findFinishedMatches();
	
}
