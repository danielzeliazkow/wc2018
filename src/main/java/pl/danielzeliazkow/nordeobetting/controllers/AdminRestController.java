package pl.danielzeliazkow.nordeobetting.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pl.danielzeliazkow.nordeobetting.utils.StatisticsGenerator;

@RestController
public class AdminRestController {
	
	@Autowired
	private StatisticsGenerator statisticsGenerator;

	@RequestMapping("/admin/addMatch")
	public void addMatch(@RequestParam("id") int id, @RequestParam("scoreOne") int scoreOne, @RequestParam("scoreTwo") int scoreTwo) {
		statisticsGenerator.updateStatisticsByMatch(id, scoreOne, scoreTwo);
	}
	
	@RequestMapping("/admin/regenerate")
	public void regenerateStatistics() {
		statisticsGenerator.generateStatisticsFromScratch();
	}
	
	
}
