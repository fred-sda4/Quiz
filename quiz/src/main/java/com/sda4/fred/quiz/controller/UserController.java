package com.sda4.fred.quiz.controller;

import com.sda4.fred.quiz.model.User;
import com.sda4.fred.quiz.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/quiz")
public class MainController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping(path = "/add")
    public @ResponseBody String addNewUser(@RequestParam String email, @RequestParam String password) {

        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        userRepository.save(user);
        return "Saved!";


    }

    @GetMapping (path ="all")
    public @ResponseBody Iterable<User>getAllUsers(){
        return userRepository.findAll();
    }


}