package com.sda4.fred.quiz.controller;

import com.sda4.fred.quiz.model.User;
import com.sda4.fred.quiz.repository.UserRepository;
import com.sda4.fred.quiz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller

public class UserController {

    @Autowired
    private UserRepository userRepository ;

    @Autowired
    UserService userService;


    @GetMapping(path = "/all")
    public @ResponseBody Iterable<User>getAllUsers(){

        return userRepository.findAll();
    }




}
