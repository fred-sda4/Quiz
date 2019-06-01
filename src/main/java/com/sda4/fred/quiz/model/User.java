package com.sda4.fred.quiz.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id ;

    @Column(name = "email")
    private String email ;

    @Column(name = "password")
    private String password ;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private Set<Quiz> quizzes ;

    public Set<Quiz> getQuizzes() {
        return quizzes;
    }

    public void setQuizzes(Set<Quiz> quizzes) {
        this.quizzes = quizzes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMail() {
        return email;
    }

    public void setMail(String mail) {
        this.email = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
