package com.restaurant.insta.service;

import com.restaurant.insta.model.Restaurant;
import com.restaurant.insta.repository.LunchRepository;
import com.restaurant.insta.to.LunchTo;
import com.restaurant.insta.to.RestaurantTo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.stream.Collectors;

@Service
public class RestaurantService {
    private static final LocalDate LOCAL_CURRENT_DATE = LocalDate.now();
    private final Logger log = LoggerFactory.getLogger(ChoiceService.class);
    private final LunchRepository lunchRepository;

    @Autowired
    public RestaurantService(LunchRepository lunchRepository) {
        this.lunchRepository = lunchRepository;
    }

    public RestaurantTo getWithLunchToday(Restaurant restaurant) {
        log.debug("Restaurant {} with lunch at {}", restaurant.getId(), LOCAL_CURRENT_DATE.toString());
        return new RestaurantTo(restaurant,
                lunchRepository.findAllByRestaurantAndDate(restaurant, LOCAL_CURRENT_DATE)
                        .stream().map(LunchTo::new).collect(Collectors.toList()));
    }
}
