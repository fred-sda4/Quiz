package com.sda4.fred.quiz.service;

import com.sda4.fred.quiz.model.Answer;
import com.sda4.fred.quiz.repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class AnswerService {

    @Autowired
    private AnswerRepository answerRepository;

    public Answer getById(Long id){

        return answerRepository.getOne(id);
    }
}
