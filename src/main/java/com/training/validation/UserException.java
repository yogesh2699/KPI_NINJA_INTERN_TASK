package com.training.validation;

public class UserException extends RuntimeException{
    public UserException(String errorMessage) {
        super(errorMessage);
    }
}
