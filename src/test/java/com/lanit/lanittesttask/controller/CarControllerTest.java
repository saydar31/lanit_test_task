package com.lanit.lanittesttask.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lanit.lanittesttask.dto.SaveCarDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.annotation.DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = BEFORE_EACH_TEST_METHOD)
class CarControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    private SaveCarDto getValidCar(){
        SaveCarDto saveCarDto = new SaveCarDto();
        saveCarDto.setId(1L);
        saveCarDto.setModel("BMW-X60");
        saveCarDto.setHorsepower(12);
        saveCarDto.setOwnerId(1L);
        return saveCarDto;
    }

    @Test
    void saveCar_noOwnerCarSave_validationError() {
        SaveCarDto saveCarDto = getValidCar();
        try {
            mockMvc.perform(
                            post("/car")
                                    .contentType(MediaType.APPLICATION_JSON)
                                    .content(objectMapper.writeValueAsString(saveCarDto))
                    )
                    .andExpect(status().is4xxClientError());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql(scripts = "/sql/add_user.sql")
    public void saveValidCar_200(){
        SaveCarDto saveCarDto = getValidCar();
        try {
            mockMvc.perform(
                            post("/car")
                                    .contentType(MediaType.APPLICATION_JSON)
                                    .content(objectMapper.writeValueAsString(saveCarDto))
                    )
                    .andDo(print())
                    .andExpect(status().is2xxSuccessful());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}