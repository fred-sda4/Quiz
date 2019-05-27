package com.sda4.fred.quiz.model;

import javax.persistence.*;

@Entity
public class Answer {

    @Id
    private Long id ;

    @Column(name = "text")
    private String text ;

    @Column(name = "correct")
    private boolean correct;

    @ManyToOne()
    @JoinColumn(name = "question_id")
    private Question question ;

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

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
