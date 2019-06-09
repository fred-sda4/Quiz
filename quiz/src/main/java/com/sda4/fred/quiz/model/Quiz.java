package com.sda4.fred.quiz.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Quiz {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "score")
	private double score;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	@ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "quiz_question",
               joinColumns = @JoinColumn(name="quizzes_id", referencedColumnName="id"),
               inverseJoinColumns = @JoinColumn(name="questions_id", referencedColumnName="id"))
    private Set<Question> questions = new HashSet<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(Set<Question> questions) {
		this.questions = questions;
	}
}
