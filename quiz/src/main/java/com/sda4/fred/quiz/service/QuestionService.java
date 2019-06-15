package com.sda4.fred.quiz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sda4.fred.quiz.model.Question;
import com.sda4.fred.quiz.respository.QuestionRepository;

@Service
@Transactional
public class QuestionService {
	
	@Autowired
	private QuestionRepository repository;
	
	@Transactional(readOnly = true)
	public List<Question> findAll(){
		
		return repository.findAll();
	}
	
	//create
	// 1. void daca vreau creez entitatea si nu ma mai intereseaza
	//   'Nu ma mai intereseaza' == vad din alt modul/ vad din alta pagina
	// 2. long == entity id (REST) => ii dau UI-ului id-ul resursei nou create
	// 3. entity nou creata => dupa creare sunt redirectat pe detalii
	public void create(Question question) {
		repository.save(question); // se aloca id din baza de date
	}
	
	public Question update(Question question) {		
		return null;
	}
	
    public void delete(Question question) {
	}   
    
    @Transactional(readOnly = true)
	public Question getById(Long id){
		
		return repository.getOne(id);
	}
}
