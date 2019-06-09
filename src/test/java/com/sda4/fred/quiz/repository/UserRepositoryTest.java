package com.sda4.fred.quiz.repository;

import com.sda4.fred.quiz.QuizApplication;
import com.sda4.fred.quiz.model.User;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = {QuizApplication.class})
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepositoryTest;

    @Test
    @Ignore
    public void createUser(){

        User user = new User();
        user.setEmail("root@gmail.com");
        user.setPassword("root");

        User result = userRepositoryTest.save(user);
        assertNotNull(user);
        assertEquals("root", result.getPassword());
        assertEquals("root@gmail.com", result.getEmail());
    }

}