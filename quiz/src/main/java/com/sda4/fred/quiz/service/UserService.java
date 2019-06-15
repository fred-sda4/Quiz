package com.sda4.fred.quiz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sda4.fred.quiz.model.User;
import com.sda4.fred.quiz.respository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	@Transactional(readOnly = true)
	public User getByEmail(String email) {
		
		return repository.findOneByEmail(email);
	}
	
	@Transactional(readOnly = true)
	public User getById(Long id) {
		
		return repository.getOne(id);
	}
	
}
