package com.restaurant.insta.exceptions;

public class DataNotFoundException extends RuntimeException{
    public DataNotFoundException(String exception) {
        super(exception);
    }
}
