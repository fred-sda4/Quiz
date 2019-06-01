package com.sda4.fred.quiz.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;

    @Column(name = "score")
    private Double score ;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user ;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "quiz_question",
    joinColumns = @JoinColumn  (name = "quizzes_id" , referencedColumnName = "id") ,
    inverseJoinColumns = @JoinColumn (name = "question_id" , referencedColumnName = "id"))
    private Set<Question> questions = new HashSet<>();

    public Set<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(Set<Question> questions) {
        this.questions = questions;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
