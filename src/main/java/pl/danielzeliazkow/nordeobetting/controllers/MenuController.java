package pl.danielzeliazkow.nordeobetting.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MenuController {
	
	@RequestMapping("/betting")
	public String openBetMenu(Model model) {
		model.addAttribute("fragmentMain", "dashboard");
		model.addAttribute("fragmentLowerMenu", "bettingLowerMenu");
		return "index";
	}
}
