package pl.danielzeliazkow.nordeobetting.utils;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.NumberUtils;

import pl.danielzeliazkow.nordeobetting.db.entity.Match;
import pl.danielzeliazkow.nordeobetting.db.entity.MatchBet;
import pl.danielzeliazkow.nordeobetting.db.entity.UserStatistics;
import pl.danielzeliazkow.nordeobetting.db.repository.MatchBetRepository;
import pl.danielzeliazkow.nordeobetting.db.repository.MatchRepository;
import pl.danielzeliazkow.nordeobetting.db.repository.UserStatisticsRepository;

@Service
@Transactional
public class StatisticsGenerator {

	@Autowired
	private MatchRepository matchRepository;
		
	@Autowired
	private MatchBetRepository matchBetRepository;
	
	@Autowired
	private UserStatisticsRepository userStatisticsRepository;
	
	public void generateStatisticsFromScratch() {
		List<Match> fisnihedMatches = matchRepository.findFinishedMatches();
		fisnihedMatches.forEach(this::updateStatistics);
	}
	
	public void updateStatisticsByMatch(int matchId, int scoreOne, int scoreTwo) {
		Match match = matchRepository.findById(matchId).get();
		updateMatch(match, scoreOne, scoreTwo);
		updateStatistics(match);
	}
	
	private void updateMatch(Match match, int scoreOne, int scoreTwo) {
		match.setIsfinished(true);
		match.setTeamOneResult(scoreOne);
		match.setTeamTwoResult(scoreTwo);
	}
	
	private void updateStatistics(Match match) {		
		List<MatchBet> bets = matchBetRepository.findMatchBetListByMatch(match.getId());		
		bets.stream().filter(this::isBetComplete).forEach(bet -> calculatePoints(bet, match));
	}
	
	private void calculatePoints(MatchBet bet, Match match) {
		UserStatistics userStatistics =  userStatisticsRepository.findStatisticsByUser(bet.getUser().getId());
		int awardedPoints = 0;
		
		if(checkGoalScorePredicted(bet, match)) {
			awardedPoints += 1;
			userStatistics.setGoalScoresPredicted(userStatistics.getGoalScoresPredicted()+1);
		}
		if(checkScorePredicted(bet, match)) {
			awardedPoints += 1;
			userStatistics.setScoresPredicted(userStatistics.getScoresPredicted()+1);
		}
		
		if(awardedPoints > 0) {			
			userStatistics.addPoints(awardedPoints);
		}
		bet.setPoints(awardedPoints);
	}
	
	private boolean checkGoalScorePredicted(MatchBet bet, Match match) {
		return bet.getTeamOneScore().equals(match.getTeamOneResult()) && 
				bet.getTeamTwoScore().equals(match.getTeamTwoResult());
	}
	
	private boolean checkScorePredicted(MatchBet bet, Match match) {
		int predictedDifference = bet.getTeamOneScore() - bet.getTeamTwoScore();
		int actualDifference = match.getTeamOneResult() - match.getTeamTwoResult();
		return Integer.signum(predictedDifference) == Integer.signum(actualDifference);
	}
	
	private boolean isBetComplete(MatchBet bet) {
		return bet.getTeamOneScore() != null && bet.getTeamTwoScore() != null;
	}
}
