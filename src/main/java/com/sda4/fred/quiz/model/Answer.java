package com.sda4.fred.quiz.model;

import javax.persistence.*;

@Entity
public class Answer {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private Long id ;

    @Column(name = "text")
    private String text ;

    @Column(name="correct")
    private boolean correct;

    @Column(name="checked")
    private boolean checked;

    @ManyToOne
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

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}
