package com.sda4.fred.quiz.repository;

import com.sda4.fred.quiz.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    User findOneByEmail(String email) ;
}
