package pl.danielzeliazkow.nordeobetting.controllers;

import java.time.LocalDateTime;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pl.danielzeliazkow.nordeobetting.db.entity.Users;
import pl.danielzeliazkow.nordeobetting.service.UserService;
import pl.danielzeliazkow.nordeobetting.validator.RetypePasswordValidator;

@Controller
public class AuthenticationController {
	
	@Autowired
	private UserService userService;
	
	
	
	@GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("fragmentMain", "signin");
        return "index";
    }
	
	@GetMapping("/register")
    public String register(Users users, Model model) {
        model.addAttribute("fragmentMain", "register");
        return "index";
    }
	
	@PostMapping("/register")
	public String registerUser(@Valid Users users, BindingResult result, Model model, RedirectAttributes redirectAttributes)
	{
		validatePasswords(users, result);
		if(result.hasErrors()) {
			model.addAttribute("fragmentMain", "register");
	        return "index";
        }
				
		if(userService.findUserByLogin(users.getLogin()) == null) {
			userService.registerNewUser(users);
		} 
		else {
			model.addAttribute("fragmentMain", "register");
			result.rejectValue("login", "msg.validation.error.login.exists");
		}
		redirectAttributes.addFlashAttribute("notificationKey","msg.info.registered.successfully");
	    return "redirect:notification";
	}

	private void validatePasswords(Users user, BindingResult result) {
		RetypePasswordValidator validator = new RetypePasswordValidator();
		validator.validate(user, result);
	}
}
