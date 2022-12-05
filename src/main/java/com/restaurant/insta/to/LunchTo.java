package com.restaurant.insta.to;

import com.restaurant.insta.model.Lunch;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LunchTo {
    private String name;
    private Integer price;

    public LunchTo(Lunch lunch) {
        this.name = lunch.getName();
        this.price = lunch.getPrice();
    }
}
