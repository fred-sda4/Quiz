package com.sda4.fred.quiz.repository;

import com.sda4.fred.quiz.model.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerRepository extends JpaRepository<Answer,Long> {

    List<Answer> getAllByQuestionId(Long id);
}
