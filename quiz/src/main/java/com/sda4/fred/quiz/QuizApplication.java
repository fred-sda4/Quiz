package com.sda4.fred.quiz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EnableJpaRepositories("com.sda4.fred.quiz.respository")
public class QuizApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(QuizApplication.class, args);
	}

}
