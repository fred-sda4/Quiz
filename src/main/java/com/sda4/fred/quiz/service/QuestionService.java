package com.sda4.fred.quiz.service;

import com.sda4.fred.quiz.model.Question;
import com.sda4.fred.quiz.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class QuestionService {

    @Autowired
    private QuestionRepository repository ;

    public List<Question> findAll(){

        return  repository.findAll();
    }
    
    //create
    //1.void daca vreau sa creez entitatea si nu ma mai intereseaza == vad din alt modul/vad din alta pagina
    //2. integer == entity id (REST) => ii dau UI-uilui id-ul resursei nou create
    //3. entity nou creata => dupa creare sunt redirectat pe detalii

    public Question updateQuestion(Question question){

        return null ;
    }

    public void delete(Question question) {


    }




}
