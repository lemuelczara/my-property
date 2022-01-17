package com.meli.myproperty.integration.property;

import java.math.BigDecimal;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
import com.meli.myproperty.modules.district.dto.DistrictInput;
import com.meli.myproperty.modules.property.dto.PropertyInput;
import com.meli.myproperty.modules.room.dto.RoomInput;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class CreatePropertyControllerTest {
    @Autowired
    private MockMvc mockMvc;

    private RoomInput makeFakeRoomInput(String name) {
        return new RoomInput(name, 10.0, 10.0);
    }

    public PropertyInput makeFakePropertyInput(String name, String districtId, String roomName) {
        return new PropertyInput(name, districtId, List.of(makeFakeRoomInput(roomName)));
    }

    public DistrictInput makeFakeDistrictInput(String name, Long value) {
        return new DistrictInput(name, BigDecimal.valueOf(value));
    }

    @Test
    public void shouldBeReturns422OnCreateProperty() throws Exception {
        mockMvc.perform(post("/properties")
                .content(asJsonString(makeFakePropertyInput("Chácara Mourão", "", "Quarto")))
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity())
                .andExpect(jsonPath("$.status").value("UNPROCESSABLE_ENTITY"));

        mockMvc.perform(post("/properties")
                .content(asJsonString(makeFakePropertyInput("Chácara Mourão", "1", "")))
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity())
                .andExpect(jsonPath("$.status").value("UNPROCESSABLE_ENTITY"));
    }

    @Test
    public void shouldBeReturns400IfPropertyNotFound() throws Exception {
        mockMvc.perform(post("/properties")
                .content(asJsonString(makeFakePropertyInput("Chácara Mourão", "1", "Quarto")))
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.status").value("BAD_REQUEST"))
                .andExpect(jsonPath("$.message").value("District not found!"));
    }

    @Test
    public void shouldBeReturns201IfPropertySuccessfullyCreated() throws Exception {
        var response = mockMvc.perform(post("/districts")
                .content(asJsonString(makeFakeDistrictInput("Bairro das Américas", 1L)))
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated())
                .andReturn();

        String id = JsonPath.read(response.getResponse().getContentAsString(), "$.id");

        mockMvc.perform(post("/properties")
                .content(asJsonString(makeFakePropertyInput("Chácara Mourão", id, "Quarto")))
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated());
    }

    private String asJsonString(Object object) {
        try {
            return new ObjectMapper().writeValueAsString(object);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
