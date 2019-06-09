package com.sda4.fred.quiz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.sda4.fred.quiz.exception.NotAuthorizedException;
import com.sda4.fred.quiz.model.User;
import com.sda4.fred.quiz.service.UserService;

@Controller
@SessionAttributes("user")
public class LoginController {
	
	
	@Autowired
	private UserService userService;
	
	@ModelAttribute("user")
    public User setUpUserForm() {
      return new User();
    }
	 
	@GetMapping("/")
    public String index() {
      return "login";
    }
	
	@PostMapping("/login")
	public ModelAndView authenticateUser(@ModelAttribute("user") User user,  ModelMap model) throws NotAuthorizedException {
				
		User dbUser = userService.getByEmail(user.getEmail());

		if (null == dbUser || false == dbUser.getPassword().equals(user.getPassword())) {
			throw new NotAuthorizedException("User not authorized!");
		}
				
	
		model.put("user", dbUser);
		
		return new ModelAndView("loginSuccessful", model);
	}
}