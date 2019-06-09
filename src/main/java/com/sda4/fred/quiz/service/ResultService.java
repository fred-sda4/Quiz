package com.sda4.fred.quiz.service;

import com.sda4.fred.quiz.model.GivenAnswer;
import com.sda4.fred.quiz.model.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
@Transactional
public class ResultService {

    @Autowired
    private GivenAnswerService givenAnswerService ;

    public Double calculateResult(Quiz quiz){

    AtomicInteger result = new AtomicInteger(0);

    quiz.getQuestions().stream().forEach(question -> {

        question.getAnswers().stream().forEach(answer -> {

            if (answer.isCorrect()){

                List<GivenAnswer> givenAnswer = givenAnswerService.getAllByQuizIdAndQuestionIdAndAnswerId(quiz.getId(),question.getId(),answer.getId());

                if (answer != null ) {

                     Integer x = result.getAndIncrement();
                    System.out.println("Correct answer "  + result);
                }
            }
        });
    });

        BigDecimal numitor = new BigDecimal(result.get()).setScale(2, RoundingMode.HALF_UP);
        BigDecimal numarator = new BigDecimal(3).setScale(2, RoundingMode.HALF_UP);
        BigDecimal rezultat = numitor.divide(numarator, 2, RoundingMode.HALF_UP);

        return rezultat.doubleValue();



    }
}
