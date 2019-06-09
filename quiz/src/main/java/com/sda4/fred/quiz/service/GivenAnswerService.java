package com.sda4.fred.quiz.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sda4.fred.quiz.model.Answer;
import com.sda4.fred.quiz.model.GivenAnswer;
import com.sda4.fred.quiz.model.Question;
import com.sda4.fred.quiz.model.Quiz;
import com.sda4.fred.quiz.respository.GivenAnswerRepository;

@Service
@Transactional
public class GivenAnswerService {

	@Autowired
	private GivenAnswerRepository repository;
	
	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private AnswerService answerService;
	
	@Autowired
	private QuizService quizService;
	
	
	public List<GivenAnswer> getAllByQuizId(Long id){
		
		return repository.getAllByQuizId(id);
	}
	
   public GivenAnswer getOneByQuizIdAndQuestionIdAndAnswerId(Long quizId, Long questionId, Long answerId){

		return repository.getOneByQuizIdAndQuestionIdAndAnswerId(quizId, questionId, answerId);
	}
   
   public GivenAnswer getOneByQuizIdAndQuestionId(Long quizId, Long questionId){
		
		return repository.getOneByQuizIdAndQuestionId(quizId, questionId);
	}

	public void create(Long quizId, Long questionId, String answerId) {
		GivenAnswer givenAnswer = new GivenAnswer();
		Quiz quiz = quizService.getById(quizId);
		Question question = questionService.getById(questionId);
		Answer answer = answerService.getById(Long.parseLong(answerId));
		
		givenAnswer.setQuiz(quiz);
		givenAnswer.setQuestion(question);
		givenAnswer.setAnswer(answer);
		
		repository.save(givenAnswer);		
	}

	public void update(GivenAnswer existingAnswer, String questionId, Long quizId, String newAnswerId) {
		existingAnswer = repository.getOne(existingAnswer.getId());
		Question question = questionService.getById(Long.parseLong(questionId));
		Quiz quiz = quizService.getById(quizId);
		Answer answer = answerService.getById(Long.parseLong(newAnswerId));


		existingAnswer.setQuiz(quiz);
		existingAnswer.setQuestion(question);
		existingAnswer.setAnswer(answer);


		repository.save(existingAnswer);
	}
}
