package com.restaurant.insta.web;

import com.restaurant.insta.testdata.LunchTestData;
import com.restaurant.insta.testdata.RestaurantTestData;
import com.restaurant.insta.testdata.UserTestData;
import org.junit.jupiter.api.Test;


class LunchControllerTest extends AbstractControllerTest {

    @Override
    @Test
    void getAll() throws Exception {
        testGetAll(LunchTestData.LUNCH_URL, UserTestData.USER);
    }

    @Override
    @Test
    void getById() throws Exception {
        testGetById(LunchTestData.LUNCH_URL + LunchTestData.LUNCH_0.getId(), UserTestData.USER);
    }

    @Override
    @Test
    void getIsNotFound() throws Exception {
        testGetIsNotFound(LunchTestData.LUNCH_URL + 100, UserTestData.USER);
    }

    @Override
    @Test
    void create() throws Exception {
        testCreate(LunchTestData.LUNCH_URL, UserTestData.ADMIN,
                objectMapper.writeValueAsString(
                        LunchTestData.getStringObjectMapLunch(RestaurantTestData.RESTAURANT_0, LOCAL_DATE, "New lunch", 200)));
    }

    @Override
    @Test
    void createIsConflict() throws Exception {
        testCreateIsConflict(LunchTestData.LUNCH_URL, UserTestData.ADMIN,
                objectMapper.writeValueAsString(
                        LunchTestData.getStringObjectMapLunch(RestaurantTestData.RESTAURANT_0, LOCAL_DATE, "Kebab", 200)
                ));
    }

    @Override
    @Test
    void createIsForbidden() throws Exception {
        testCreateIsForbidden(LunchTestData.LUNCH_URL, UserTestData.USER,
                objectMapper.writeValueAsString(
                        LunchTestData.getStringObjectMapLunch(RestaurantTestData.RESTAURANT_0, LOCAL_DATE, "New lunch", 200)));
    }

    @Override
    @Test
    void update() throws Exception {
        testUpdate(LunchTestData.LUNCH_URL + LunchTestData.LUNCH_0.getId(), UserTestData.ADMIN,
                objectMapper.writeValueAsString(
                        LunchTestData.getStringObjectMapLunch(RestaurantTestData.RESTAURANT_2, LOCAL_DATE, "Update lunch", 100)
                ));
    }

    @Override
    @Test
    void updatedIsConflict() throws Exception {
        testUpdateIsConflict(LunchTestData.LUNCH_URL + LunchTestData.LUNCH_0.getId(), UserTestData.ADMIN,
                objectMapper.writeValueAsString(
                        LunchTestData.getStringObjectMapLunch(RestaurantTestData.RESTAURANT_0, LOCAL_DATE, "Kebab", 100)
                ));
    }

    @Override
    @Test
    void updateIsForbidden() throws Exception {
        testUpdateIsForbidden(LunchTestData.LUNCH_URL + LunchTestData.LUNCH_0.getId(), UserTestData.USER,
                objectMapper.writeValueAsString(
                        LunchTestData.getStringObjectMapLunch(RestaurantTestData.RESTAURANT_2, LOCAL_DATE, "Kebab", 100)
                ));
    }

    @Override
    @Test
    void deleted() throws Exception {
        testDelete(LunchTestData.LUNCH_URL + LunchTestData.LUNCH_0.getId(), UserTestData.ADMIN);
    }

    @Override
    @Test
    void deletedIsForbidden() throws Exception {
        testDeleteIsForbidden(LunchTestData.LUNCH_URL + LunchTestData.LUNCH_0.getId(), UserTestData.USER);
    }
}
