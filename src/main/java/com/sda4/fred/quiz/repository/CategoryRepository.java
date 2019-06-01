package com.sda4.fred.quiz.repository;

import com.sda4.fred.quiz.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {


}
