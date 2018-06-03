package pl.danielzeliazkow.nordeobetting.db.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.danielzeliazkow.nordeobetting.db.entity.MatchBet;
import pl.danielzeliazkow.nordeobetting.db.entity.Users;

@Transactional
@Repository 
public interface MatchBetRepository extends JpaRepository<MatchBet, Integer>{

	@Transactional(readOnly=true)
	@Query("select mb from MatchBet mb where mb.user = ?1 order by mb.match.date")
	public List<MatchBet> findMatchBetListByUser(Users user);
	
	@Modifying
	@Query("update MatchBet mb set mb.teamOneScore = :teamOneScore, mb.teamTwoScore = :teamTwoScore where mb.id = :id")
	public void updateUserBets(@Param("teamOneScore") Integer teamOneScore, @Param("teamTwoScore") Integer teamTwoScore, @Param("id") int id);
}
