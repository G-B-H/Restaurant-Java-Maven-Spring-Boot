package com.restaurant.insta.exceptions;

public class RestaurantNotFoundException extends RuntimeException {
    public RestaurantNotFoundException(String exception) {
        super(exception);
    }
}