package com.sda4.fred.quiz.repository;

import com.sda4.fred.quiz.model.GivenAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GivenAnswerRepository extends JpaRepository<GivenAnswer,Long> {

    List<GivenAnswer> getAllById(Long id) ;

    List<GivenAnswer> getAllByQuizIdAndQuestionId(Long quizId , Long questionId) ;

    List<GivenAnswer> getAllByQuizIdAndQuestionIdAndAnswerId(Long quizId, Long questionId,Long answerId) ;




}
