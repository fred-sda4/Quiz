package com.sda4.fred.quiz.exception;

public class NotAuthorizedException extends Exception {


    public static final long serialVersionUID = 1L ;

    public NotAuthorizedException(String message) {
        super(message);
    }
}
