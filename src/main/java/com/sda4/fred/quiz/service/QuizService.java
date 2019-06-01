package com.sda4.fred.quiz.service;

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

    public Quiz createQuiz(Quiz quiz) {

        return quizRepository.save(quiz);
    }

    public Quiz createQuiz(User user) {

        Quiz quiz = new Quiz();
        quiz.setUser(user);
        user.getQuizzes().add(quizRepository.save(quiz));
        userRepository.save(user);

        return quiz ;
    }
}
