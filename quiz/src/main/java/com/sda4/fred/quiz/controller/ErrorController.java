package com.sda4.fred.quiz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ErrorController {

	
	@GetMapping("/error")
	public ModelAndView authenticateUser(ModelMap model){
					
		return new ModelAndView("error", model);
	}
}
