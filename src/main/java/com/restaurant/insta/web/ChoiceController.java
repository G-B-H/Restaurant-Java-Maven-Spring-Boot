package com.restaurant.insta.web;

import com.restaurant.insta.model.Restaurant;
import com.restaurant.insta.util.ChoiceStatus;
import com.restaurant.insta.exceptions.RestaurantNotFoundException;
import com.restaurant.insta.service.ChoiceService;
import com.restaurant.insta.userdetails.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping(value = "/api/choice", produces = MediaTypes.HAL_JSON_VALUE)
public class ChoiceController {
    private final ChoiceService choiceService;

    @Autowired
    public ChoiceController(ChoiceService choiceService) {
        this.choiceService = choiceService;
    }

    @GetMapping
    public ResponseEntity<Restaurant> current(@AuthenticationPrincipal UserPrincipal userPrincipal) throws RestaurantNotFoundException {
        return new ResponseEntity<>(choiceService.getCurrent(userPrincipal.getUser()), HttpStatus.OK);
    }

    @PostMapping("/{id}")
    public ResponseEntity<Restaurant> choice(@AuthenticationPrincipal UserPrincipal userPrincipal, @PathVariable("id") Restaurant restaurant) {
        ChoiceStatus choiceStatus = choiceService.choiceStatus(userPrincipal.getUser(), restaurant);
        return new ResponseEntity<>(choiceStatus.getChoice().getRestaurant(), choiceStatus.isCreated() ? HttpStatus.CREATED : HttpStatus.OK);
    }
}
