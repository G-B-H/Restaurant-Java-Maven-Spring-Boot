package com.restaurant.insta.web;


import com.restaurant.insta.testdata.UserTestData;
import com.restaurant.insta.utils.TestUtil;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Map;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


class UserControllerTest extends AbstractControllerTest {

    @Override
    @Test
    void getAll() throws Exception {
        testGetAll(UserTestData.USERS_URL, UserTestData.ADMIN);
    }

    @Override
    @Test
    void getById() throws Exception {
        testGetById(UserTestData.USERS_URL + UserTestData.USER_ID, UserTestData.ADMIN)
                .andExpect(MockMvcResultMatchers.jsonPath("name", Matchers.is(UserTestData.USER.getName())))
                .andExpect(MockMvcResultMatchers.jsonPath("email", Matchers.is(UserTestData.USER.getEmail())));
    }

    @Test
    void getUserByEmail() throws Exception {
        mockMvc
                .perform(get(UserTestData.USERS_URL + "search/by-email")
                        .param("email", UserTestData.USER.getEmail())
                        .with(TestUtil.userHttpBasic(UserTestData.ADMIN)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("name", Matchers.is(UserTestData.USER.getName())))
                .andExpect(MockMvcResultMatchers.jsonPath("email", Matchers.is(UserTestData.USER.getEmail())));
    }

    @Test
    void getIsForbidden() throws Exception {
        testGetIsForbidden(UserTestData.USERS_URL, UserTestData.USER);
    }

    @Override
    @Test
    void getIsNotFound() throws Exception {
        testGetIsNotFound(UserTestData.USERS_URL + 2, UserTestData.ADMIN);
    }

    @Test
    void notFound() throws Exception {
        testGetIsNotFound(REST_URL + "/user", UserTestData.ADMIN);
    }

    @Override
    @Test
    void create() throws Exception {
        testCreate(UserTestData.USERS_URL, UserTestData.ADMIN, objectMapper.writeValueAsString(UserTestData.getCreatedUser()));
    }

    @Override
    @Test
    void createIsConflict() throws Exception {
        Map<String, Object> created = UserTestData.getCreatedUser();
        created.put("email", "user@gmail.com");

        testCreateIsConflict(UserTestData.USERS_URL, UserTestData.ADMIN, objectMapper.writeValueAsString(created));
    }

    @Override
    @Test
    void createIsForbidden() throws Exception {
        testCreateIsForbidden(UserTestData.USERS_URL, UserTestData.USER, objectMapper.writeValueAsString(UserTestData.getCreatedUser()));
    }

    @Override
    @Test
    void update() throws Exception {
        testUpdate(UserTestData.USERS_URL + UserTestData.USER_ID, UserTestData.ADMIN, objectMapper.writeValueAsString(UserTestData.getUpdateUser()));
    }

    @Override
    @Test
    void updatedIsConflict() throws Exception {
        Map<String, Object> update = UserTestData.getUpdateUser();
        update.put("email", "admin@gmail.com");

        testUpdateIsConflict(UserTestData.USERS_URL + UserTestData.USER_ID, UserTestData.ADMIN, objectMapper.writeValueAsString(update));

    }

    @Override
    @Test
    void updateIsForbidden() throws Exception {
        testUpdateIsForbidden(UserTestData.USERS_URL + UserTestData.USER_ID, UserTestData.USER, objectMapper.writeValueAsString(UserTestData.getUpdateUser()));
    }

    @Override
    @Test
    void deleted() throws Exception {
        testDelete(UserTestData.USERS_URL + UserTestData.USER_ID, UserTestData.ADMIN);
    }

    @Override
    @Test
    void deletedIsForbidden() throws Exception {
        testDeleteIsForbidden(UserTestData.USERS_URL + UserTestData.USER_ID, UserTestData.USER);
    }
}
