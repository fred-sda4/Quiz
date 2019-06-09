package com.sda4.fred.quiz.service;

import com.sda4.fred.quiz.model.Question;
import com.sda4.fred.quiz.model.Quiz;
import com.sda4.fred.quiz.model.User;
import com.sda4.fred.quiz.repository.QuizRepository;
import com.sda4.fred.quiz.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class QuizService {

    @Autowired
    private QuizRepository quizRepository;

    @Autowired
    UserRepository userRepository ;

    @Autowired
    QuestionService questionService;

    @Autowired
    AnswerService answerService ;


    public Quiz createQuiz(Quiz quiz) {

        return quizRepository.save(quiz);
    }

    public Quiz createQuiz(User user) {


        User dbUser = userRepository.getOne(user.getId());
        Quiz quiz = new Quiz();
        quiz.setUser(dbUser);
        user.getQuizzes().add((quiz));
        userRepository.save(user);

        return quizRepository.save(quiz) ;
    }

    public Quiz addQuestionsById(Quiz quiz , Long id){

        quiz = quizRepository.getOne(quiz.getId());

        Question question =questionService.getById(id);

        quiz.getQuestions().add(question);

        return quizRepository.save(quiz);
    }

    public Quiz getById(Long quizId) {

        return quizRepository.getOne(quizId);
    }


}
