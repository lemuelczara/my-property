package com.meli.myproperty.integration.district;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

import java.math.BigDecimal;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.meli.myproperty.modules.district.dto.DistrictInput;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class CreateDistrictControllerTest {
    @Autowired
    private MockMvc mockMvc;

    public DistrictInput makeFakeDistrictInput(String name, Long value) {
        return new DistrictInput(name, BigDecimal.valueOf(value));
    }

    @Test
    public void shouldBeReturns422OnCreateDistrict() throws Exception {
        mockMvc.perform(post("/districts")
                .content(asJsonString(makeFakeDistrictInput("", 1L)))
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity())
                .andExpect(jsonPath("$.status").value("UNPROCESSABLE_ENTITY"));

        mockMvc.perform(post("/districts")
                .content(asJsonString(makeFakeDistrictInput(null, 12312312312312L)))
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity())
                .andExpect(jsonPath("$.status").value("UNPROCESSABLE_ENTITY"))
                .andExpect(jsonPath("$.data.name").exists())
                .andExpect(jsonPath("$.data.squareMeterPrice").exists());
    }

    private String asJsonString(Object object) {
        try {
            return new ObjectMapper().writeValueAsString(object);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
