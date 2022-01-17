package com.meli.myproperty.integration.district;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.math.BigDecimal;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
import com.meli.myproperty.modules.district.dto.DistrictInput;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class FindDistrictByIdControllerTest {
    @Autowired
    private MockMvc mockMvc;

    public DistrictInput makeFakeDistrictInput(String name, Long value) {
        return new DistrictInput(name, BigDecimal.valueOf(value));
    }

    @Test
    public void shouldBeReturn400IfDistrictNotFound() throws Exception {
        mockMvc.perform(get("/districts/1"))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.status").value("BAD_REQUEST"))
                .andExpect(jsonPath("$.code").value("400"));
    }

    @Test
    public void shouldBeReturn200IfDistrictExists() throws Exception {
        var response = mockMvc.perform(post("/districts")
                .content(asJsonString(makeFakeDistrictInput("Bairro das Palmeiras", 1L)))
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated())
                .andReturn();

        String id = JsonPath.read(response.getResponse().getContentAsString(), "$.id");

        mockMvc.perform(get("/districts/{id}", id))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.name").value("Bairro das Palmeiras"));
    }

    private String asJsonString(Object object) {
        try {
            return new ObjectMapper().writeValueAsString(object);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
