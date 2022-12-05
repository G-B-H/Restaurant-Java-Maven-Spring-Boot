package com.restaurant.insta.testdata;

import com.restaurant.insta.model.Restaurant;
import com.restaurant.insta.model.Lunch;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import static com.restaurant.insta.testdata.RestaurantTestData.*;
import static com.restaurant.insta.web.AbstractControllerTest.REST_URL;


public class LunchTestData {
    public static final String LUNCH_URL = REST_URL + "/lunch/";

    //RESTAURANT_0
    public static final Lunch LUNCH_0 = new Lunch(0L, "Burger", LocalDate.now(), 100, RESTAURANT_0);
    public static final Lunch LUNCH_1 = new Lunch(1L, "Kebab", LocalDate.of(2018, 5, 23), 75, RESTAURANT_0);
    //RESTAURANT_1
    public static final Lunch LUNCH_2 = new Lunch(2L, "HotDog", LocalDate.now(), 118, RESTAURANT_1);
    public static final Lunch LUNCH_3 = new Lunch(3L, "Pizza", LocalDate.of(2018, 5, 23), 164, RESTAURANT_1);
    //RESTAURANT_2
    public static final Lunch LUNCH_4 = new Lunch(4L, "Panini", LocalDate.now(), 120, RESTAURANT_2);
    public static final Lunch LUNCH_5 = new Lunch(5L, "Crepe", LocalDate.of(2018, 5, 23), 80, RESTAURANT_2);

    public static Map<String, Object> getStringObjectMapLunch(Restaurant restaurant, LocalDate date, String name, int price) {
        return new HashMap<>() {{
            put("restaurant", RESTAURANT_URL + restaurant.getId());
            put("date", date);
            put("name", name);
            put("price", price);
        }};
    }
}
