package com.lanit.lanittesttask.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.annotation.DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = BEFORE_EACH_TEST_METHOD)
class StatisticsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @Sql({"/sql/add_user.sql", "/sql/add_car.sql"})
    public void getStatisticsIsEqual() {
        try {
            mockMvc.perform(get("/statistics"))
                    .andDo(print())
                    .andExpect(status().is2xxSuccessful())
                    .andExpect(jsonPath("$.personcount", is(1)))
                    .andExpect(jsonPath("$.uniquevendorcount", is(2)))
                    .andExpect(jsonPath("$.carcount", is(3)));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}