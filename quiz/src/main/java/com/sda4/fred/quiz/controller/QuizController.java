package com.sda4.fred.quiz.controller;

import com.sda4.fred.quiz.model.Question;
import com.sda4.fred.quiz.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.sda4.fred.quiz.exception.NotAuthorizedException;
import com.sda4.fred.quiz.model.Quiz;
import com.sda4.fred.quiz.model.User;
import com.sda4.fred.quiz.service.QuizService;

@Controller
@SessionAttributes("quiz")
public class QuizController {
	
	@Autowired
	private QuizService quizService;

	@Autowired
	private QuestionService questionService;

	@ModelAttribute("question")
	public Question setUpUserForm() {
		return questionService.getById(1l);
	}

	@PostMapping("/quiz")
	public ModelAndView authenticateUser(@SessionAttribute("user") User user,  ModelMap model) throws NotAuthorizedException {
	
		if (null == user) {
			throw new IllegalArgumentException("User object is null!");
		}

		Quiz quiz = quizService.addQuestionById(quizService.createQuiz(user), 1l);
		//Question question = questionService.getById(1l);
		//model.put("question", question);
		model.put("quiz", quiz);
		
		return new ModelAndView("question", model);
	}
}
