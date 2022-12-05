package com.restaurant.insta.testdata;

import com.restaurant.insta.model.Restaurant;

import java.util.HashMap;
import java.util.Map;

import static com.restaurant.insta.web.AbstractControllerTest.REST_URL;


public class RestaurantTestData {
    public static final String RESTAURANT_URL = REST_URL + "/restaurants/";

    public static final Restaurant RESTAURANT_0 = new Restaurant(0L, "McDonalds");
    public static final Restaurant RESTAURANT_1 = new Restaurant(1L, "Burger King");
    public static final Restaurant RESTAURANT_2 = new Restaurant(2L, "KFC");

    public static Map<String, Object> getStringObjectMapRestaurant(String name) {
        return new HashMap<>() {{
            put("name", name);
        }};
    }
}
