package com.sda4.fred.quiz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sda4.fred.quiz.model.GivenAnswer;
import com.sda4.fred.quiz.model.Quiz;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.concurrent.atomic.AtomicInteger;

@Service
@Transactional
public class ResultService {

		@Autowired
		private GivenAnswerService givenAnswerService;

		public double calculateResult(Quiz quiz) {
			final AtomicInteger result = new AtomicInteger(0);
			quiz.getQuestions().stream().forEach(question -> {
				question.getAnswers().stream().forEach(answer -> {
					if (answer.isCorrect()) {
						GivenAnswer givenAnswer = givenAnswerService.getOneByQuizIdAndQuestionIdAndAnswerId(quiz.getId(), question.getId(), answer.getId());
						if (givenAnswer != null) {
							//result.add(new BigDecimal(1));
							Integer x = result.getAndIncrement();
							System.out.println("Correct answer !" + x);
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
