package com.sda4.fred.quiz.model.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sda4.fred.quiz.model.Category;

@Repository
public interface CategoryRepository  extends JpaRepository<Category, Long> {

}
