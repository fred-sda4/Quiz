package com.sda4.fred.quiz.controller;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sda4.fred.quiz.exception.NotAuthorizedException;
import com.sda4.fred.quiz.model.User;
import com.sda4.fred.quiz.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;

//	@RequestMapping(value = "/quiz",  method = POST)
//	public ModelAndView authenticateUser(@ModelAttribute("user") User user,  ModelMap model) throws NotAuthorizedException {
//	
//		if (null == user) {
//			throw new IllegalArgumentException("User object is null!");
//		}
//				
//		model.put("user", userService.createQuiz(user));
//		
//		return new ModelAndView("loginSuccessful", model);
//	}
}
