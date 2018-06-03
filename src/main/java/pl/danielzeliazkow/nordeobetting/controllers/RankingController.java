package pl.danielzeliazkow.nordeobetting.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.danielzeliazkow.nordeobetting.db.entity.UserStatistics;
import pl.danielzeliazkow.nordeobetting.db.repository.UserStatisticsRepository;

@Controller
public class RankingController {

	@Autowired
	private UserStatisticsRepository userStatisticsRepository;
	
	@RequestMapping("/ranking")
	public String showRanking(Model model) {
		model.addAttribute("ranking", userStatisticsRepository.findAllByOrderByPointsAsc());
		
		model.addAttribute("fragmentMain", "ranking");
        return "index";
	}
}
