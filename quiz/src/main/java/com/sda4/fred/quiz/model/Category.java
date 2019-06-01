package com.sda4.fred.quiz.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class QuestionCategory {
    @Id
    private Integer id;

    @Column (name= "category")
    private String category;
}
