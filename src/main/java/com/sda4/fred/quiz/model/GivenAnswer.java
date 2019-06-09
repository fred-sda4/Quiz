package com.sda4.fred.quiz.model;

import javax.persistence.*;

@Entity
public class GivenAnswer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question ;

    @ManyToOne
    @JoinColumn(name = "answer_id")
    private Answer answer ;

    @ManyToOne
    @JoinColumn(name = "quiz_id")
    private Quiz quiz ;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }
}
