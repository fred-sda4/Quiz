package com.sda4.fred.quiz.service;

import com.sda4.fred.quiz.model.Answer;
import com.sda4.fred.quiz.model.GivenAnswer;
import com.sda4.fred.quiz.model.Question;
import com.sda4.fred.quiz.model.Quiz;
import com.sda4.fred.quiz.repository.GivenAnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class GivenAnswerService {

    @Autowired
    GivenAnswerRepository givenAnswerServiceRepository;

    @Autowired
    QuestionService questionService ;

    @Autowired
    AnswerService answerService ;

    @Autowired
    QuizService quizService;

    public List<GivenAnswer> getAllByQuizId(Long id) {

        return givenAnswerServiceRepository.getAllById(id);
    }

    public List<GivenAnswer> getAllByQuizIdAndQuestionId(Long quizId , Long questionId) {

        return  givenAnswerServiceRepository.getAllByQuizIdAndQuestionId(quizId,questionId);
    }

    public List<GivenAnswer> getAllByQuizIdAndQuestionIdAndAnswerId(Long quizId, Long questionId,Long answerId) {

        return givenAnswerServiceRepository.getAllByQuizIdAndQuestionIdAndAnswerId(quizId,questionId,answerId) ;
    }

    public void create(Long quizId,Long questionId , Long answerId) {

        GivenAnswer givenAnswer = new GivenAnswer() ;
        Quiz quiz = quizService.getById(quizId);
        Question question = questionService.getById(questionId);
        Answer answer = answerService.getById(answerId);

        givenAnswer.setQuiz(quiz);
        givenAnswer.setQuestion(question);
        givenAnswer.setAnswer(answer);

         givenAnswerServiceRepository.save(givenAnswer);
    }

    public void update(GivenAnswer existingAnswer, String answerId) {
        existingAnswer = givenAnswerServiceRepository.getOne(existingAnswer.getId());
        Answer answer = answerService.getById(Long.parseLong(answerId));
        existingAnswer.setAnswer(answer);

        givenAnswerServiceRepository.save(existingAnswer);
    }


}
