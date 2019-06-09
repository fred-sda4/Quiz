//package com.sda4.fred.quiz.repository;
//
//import com.sda4.fred.quiz.QuizApplication;
//import com.sda4.fred.quiz.model.User;
//import com.sda4.fred.quiz.respository.UserRepository;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import static org.junit.Assert.assertNotNull;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@ContextConfiguration(classes = {QuizApplication.class})
//public class UserRepositoryTest {
//
//    @Autowired
//    private UserRepository repository;
//
//    @Test
//    public void createUser(){
//        User user = new User();
//      user.setEmail("test@test.com");
//     user.setPassword("test");
//
//        User result = repository.save(user);
//        assertNotNull(result);
//    }
//}