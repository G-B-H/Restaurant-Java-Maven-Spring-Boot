package com.restaurant.insta.to;

import com.restaurant.insta.model.Restaurant;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@NoArgsConstructor
@Data
public class RestaurantTo {
    private List<LunchTo> lunches;
    private String name;

    public RestaurantTo(Restaurant restaurant, List<LunchTo> lunches) {
        this.name = restaurant.getName();
        this.lunches = lunches;
    }
}
