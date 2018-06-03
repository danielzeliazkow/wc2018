package pl.danielzeliazkow.nordeobetting.controllers;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class WelcomeController {
	
	@RequestMapping("/welcome")
    public String welcomPage(Model model) {
		System.out.println("uda³o sie zalogowac");
        model.addAttribute("fragmentMain", "dashboard");
        return "index";
    }
	
	@RequestMapping("/notification")
    public String showNotification(Model model, @ModelAttribute("notificationKey") String notificationKey, @ModelAttribute("fragmentLowerMenuPassed") String fragmentLowerMenuPassed) {	
		System.out.println(notificationKey);
		
		if(!StringUtils.isEmpty(fragmentLowerMenuPassed)) {
			model.addAttribute("fragmentLowerMenu", fragmentLowerMenuPassed);
		}
		
		model.addAttribute("notificationMessage", notificationKey);
		model.addAttribute("fragmentMain", "notification");
        return "index";
	}
}
