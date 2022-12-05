package com.restaurant.insta.repository;

import com.restaurant.insta.model.Restaurant;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.transaction.annotation.Transactional;

@RepositoryRestResource(collectionResourceRel = "restaurant", path = "restaurants")
public interface RestaurantRepository extends AdminSecurityRepository<Restaurant> {

    @RestResource(path = "by-name")
    @Transactional(readOnly = true)
    Restaurant findByName(@Param("name") String name);
}
