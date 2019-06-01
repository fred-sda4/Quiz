package com.sda4.fred.quiz.repository;

import com.sda4.fred.quiz.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizRepository  extends JpaRepository<Quiz,Long> {


}
