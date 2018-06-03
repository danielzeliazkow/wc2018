package pl.danielzeliazkow.nordeobetting.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.danielzeliazkow.nordeobetting.db.entity.Match;
import pl.danielzeliazkow.nordeobetting.db.entity.MatchBet;
import pl.danielzeliazkow.nordeobetting.db.entity.Users;
import pl.danielzeliazkow.nordeobetting.db.repository.MatchBetRepository;
import pl.danielzeliazkow.nordeobetting.db.repository.MatchRepository;

@Service
public class MatchBetService {
	
	
	@Autowired
	private MatchBetRepository matchBetRepository;	

	@Autowired
	private MatchRepository matchRepository;
	
	public List<MatchBet> getFinishedMatchBetsForUser(Users user){
		List<MatchBet> list = matchBetRepository.findMatchBetListByUser(user);
		return list.stream().filter(this::isBettingClosed)
			.filter(m -> m.getMatch().isIsfinished()).collect(Collectors.toList());
	}
	
	public List<MatchBet> getPendingMatchBetsForUser(Users user){
		List<MatchBet> list = matchBetRepository.findMatchBetListByUser(user);
		return list.stream().filter(this::isBettingClosed)
			.filter(m -> !m.getMatch().isIsfinished()).collect(Collectors.toList());
	}
	
	public List<MatchBet> getUpcomingMatchBetsForUser(Users user){
		List<MatchBet> list = matchBetRepository.findMatchBetListByUser(user);
		return list.stream().filter(this::isBettingNotClosed)
			.collect(Collectors.toList());
	}
	
	public void createMatchBetsForUser(Users user) {
		List<Match> matchList = matchRepository.findAll();
		
		for(Match match : matchList) {
			MatchBet bet = new MatchBet();
			bet.setMatch(match);
			bet.setUser(user);
			matchBetRepository.save(bet);
		}
	}
	
	public void updateUserBets(List<MatchBet> betList) {
		betList.forEach(bet -> matchBetRepository.updateUserBets(bet.getTeamOneScore(), bet.getTeamTwoScore(), bet.getId()));	
	}
	
	private boolean isBettingClosed(MatchBet m) {
		return LocalDateTime.now().isAfter(m.getMatch().getDate().minusHours(2));
	}
	
	private boolean isBettingNotClosed(MatchBet m) {
		return !isBettingClosed(m);
	}
	

}
