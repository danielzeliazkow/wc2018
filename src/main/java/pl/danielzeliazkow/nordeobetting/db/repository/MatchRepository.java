package pl.danielzeliazkow.nordeobetting.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.danielzeliazkow.nordeobetting.db.entity.Match;
import pl.danielzeliazkow.nordeobetting.db.entity.MatchBet;

public interface MatchRepository extends JpaRepository<Match, Integer>{
	
	
}
