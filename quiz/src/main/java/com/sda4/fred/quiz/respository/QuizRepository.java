package com.sda4.fred.quiz.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sda4.fred.quiz.model.Quiz;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Long> {

}
