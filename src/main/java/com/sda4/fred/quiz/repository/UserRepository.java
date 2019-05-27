package com.sda4.fred.quiz.repository;

import com.sda4.fred.quiz.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Integer> {


}
