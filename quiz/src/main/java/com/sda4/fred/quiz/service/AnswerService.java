package com.sda4.fred.quiz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sda4.fred.quiz.model.Answer;
import com.sda4.fred.quiz.respository.AnswerRepository;

@Service
@Transactional
public class AnswerService {
	
	@Autowired
	private AnswerRepository answerRepository;

	public Answer getById(long id) {

		return answerRepository.getOne(id);
	}

}
