package com.sda4.fred.quiz.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;


    @Column(name = "text")
    private String text ;

    @OneToMany(mappedBy = "question" , fetch = FetchType.EAGER)
    private List<Answer> answers ;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
