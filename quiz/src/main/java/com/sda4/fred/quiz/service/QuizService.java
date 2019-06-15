package com.sda4.fred.quiz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sda4.fred.quiz.model.Question;
import com.sda4.fred.quiz.model.Quiz;
import com.sda4.fred.quiz.model.User;
import com.sda4.fred.quiz.respository.QuizRepository;
import com.sda4.fred.quiz.respository.UserRepository;

@Service
@Transactional
public class QuizService {
	
	@Autowired
	private QuizRepository repository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private AnswerService answerService;
	
	public Quiz createQuiz(Quiz quiz) {
		
		return repository.save(quiz);
	}
	
	public Quiz createQuiz(User user) {
		//Inefficient read (duplicate)
		User dbUser = userRepository.getOne(user.getId());
		Quiz quiz = new Quiz();
		quiz.setUser(dbUser);
		user.getQuizzes().add(quiz);
		userRepository.save(user);
		
		return repository.save(quiz);
	}

	public Quiz addQuestionById(Quiz quiz, long id) {
		quiz = repository.getOne(quiz.getId());
		Question question = questionService.getById(id);
		quiz.getQuestions().add(question);
		
		return repository.save(quiz);
	}

	public Quiz getById(Long quizId) {
		
		return repository.getOne(quizId);
	}
}
