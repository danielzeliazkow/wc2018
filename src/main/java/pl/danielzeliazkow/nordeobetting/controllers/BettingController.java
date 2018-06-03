package pl.danielzeliazkow.nordeobetting.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.SmartValidator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pl.danielzeliazkow.nordeobetting.db.entity.MatchBet;
import pl.danielzeliazkow.nordeobetting.db.entity.Users;
import pl.danielzeliazkow.nordeobetting.dto.BetsListDto;
import pl.danielzeliazkow.nordeobetting.service.MatchBetService;
import pl.danielzeliazkow.nordeobetting.service.UserService;

@Controller
public class BettingController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private MatchBetService matchBetService;
	
	@Autowired
	private SmartValidator validator;
	
	@RequestMapping("/upcomingMatches")
	public String showUpcomingMatches(BetsListDto bets, Model model, Authentication authentication){
		Users user = userService.findUserByLogin(authentication.getName());
		bets = new BetsListDto(matchBetService.getUpcomingMatchBetsForUser(user));
		model.addAttribute("bets", bets);
		model.addAttribute("fragmentMain", "upcomingMatches");
		model.addAttribute("fragmentLowerMenu", "bettingLowerMenu");
		return "index";
	}
	
	@PostMapping("/saveBets")
	public String saveBets(BetsListDto bets, Model model, BindingResult result, RedirectAttributes redirectAttributes) {
		
		bets.getList().forEach( bet -> validator.validate(bet, result));
		
		if(result.hasErrors()) {
			model.addAttribute("bets", bets);
			model.addAttribute("fragmentMain", "upcomingMatches");
	        return "index";
		 }    
	    
		matchBetService.updateUserBets(bets.getList());
		redirectAttributes.addFlashAttribute("notificationKey","msg.info.bets.saved");
		return "redirect:notification";
	}
	
	@RequestMapping("/pendingMatches")
	public String showPendingMatches(Model model, RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("fragmentLowerMenu", "bettingLowerMenu");
		redirectAttributes.addFlashAttribute("notificationKey","msg.info.betting.nomatches");
		model.addAttribute("fragmentLowerMenu", "bettingLowerMenu");
	    return "redirect:notification";
	}
	
	@RequestMapping("/finishedMatches")
	public String showFinishedMatches(Model model, RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("fragmentLowerMenu", "bettingLowerMenu");
		redirectAttributes.addFlashAttribute("notificationKey","msg.info.betting.nomatches");
		model.addAttribute("fragmentLowerMenu", "bettingLowerMenu");
	    return "redirect:notification";
	}
}
