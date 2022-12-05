package com.restaurant.insta.exceptions;

public class ValidationLimitException extends RuntimeException{
    public ValidationLimitException(String exception) {
        super(exception);
    }
}
