package com.sda4.fred.quiz.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sda4.fred.quiz.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	User findOneByEmail(String email);
}