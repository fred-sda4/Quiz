package com.sda4.fred.quiz.controller;

import com.sda4.fred.quiz.model.Question;
import com.sda4.fred.quiz.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping(value = "/questions")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @RequestMapping(value ="/all", method = RequestMethod.GET)
    public ResponseEntity <List<Question>> getQuestions(){
        List<Question> questions = questionService.findAll();
        if (questions.isEmpty()){

            return new ResponseEntity<List<Question>>(HttpStatus.NO_CONTENT);
        }else {

            return new ResponseEntity<List<Question>>(questions, HttpStatus.OK);
        }
    }
}
