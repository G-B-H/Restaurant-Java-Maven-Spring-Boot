package com.restaurant.insta.repository;

import com.restaurant.insta.model.Restaurant;
import com.restaurant.insta.model.Lunch;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;


@RepositoryRestResource(collectionResourceRel = "lunch", path = "lunch")
public interface LunchRepository extends AdminSecurityRepository<Lunch> {

    @RestResource(path = "by-date")
    @Transactional(readOnly = true)
    List<Lunch> findAllByDate(@Param("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date);

    @RestResource(path = "by-restaurant")
    @Transactional(readOnly = true)
    List<Lunch> findAllByRestaurant(@Param("restaurant") Restaurant restaurant);

    @RestResource(path = "by-restaurant-and-date")
    @Transactional(readOnly = true)
    List<Lunch> findAllByRestaurantAndDate(@Param("restaurant") Restaurant restaurant, @Param("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date);
}
