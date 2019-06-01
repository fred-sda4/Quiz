package com.sda4.fred.quiz.controller;

import com.sda4.fred.quiz.exception.NotAuthorizedException;
import com.sda4.fred.quiz.model.Question;
import com.sda4.fred.quiz.model.Quiz;
import com.sda4.fred.quiz.model.User;
import com.sda4.fred.quiz.repository.UserRepository;
import com.sda4.fred.quiz.service.AnswerService;
import com.sda4.fred.quiz.service.QuestionService;
import com.sda4.fred.quiz.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path="/quiz")
public class QuizController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private QuizService quizService ;

    @Autowired
    private QuestionService questionService;

    @Autowired
    AnswerService answerService;

    @PostMapping(path = "/quiz")
    public ModelAndView authenticatUser(@SessionAttribute("user")User user , ModelMap model) throws NotAuthorizedException {

        if (user == null) {

            throw new IllegalArgumentException("User object is null !!! ") ;
        }

        Quiz quiz = quizService.createQuiz(user);
        Question question = questionService.getById(1L);

        model.put("user", user);
        model.put("question",question);

        return new ModelAndView("question",model);
    }

    @GetMapping(path = "/add")
    public @ResponseBody
    String addNewUser(@RequestParam String email , @RequestParam String password) {

        User user = new User();
        user.setMail(email);
        user.setPassword(password);
        userRepository.save(user);
        return "Saved ! " ;

    }
}
