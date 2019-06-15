package com.sda4.fred.quiz.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sda4.fred.quiz.model.GivenAnswer;

@Repository
public interface GivenAnswerRepository extends JpaRepository<GivenAnswer, Long> {

    List<GivenAnswer> getAllByQuizId(Long id);

	GivenAnswer getOneByQuizIdAndQuestionId(Long quizId, Long questionId);

	GivenAnswer getOneByQuizIdAndQuestionIdAndAnswerId(Long quizId, Long questionId, Long answerId);
}