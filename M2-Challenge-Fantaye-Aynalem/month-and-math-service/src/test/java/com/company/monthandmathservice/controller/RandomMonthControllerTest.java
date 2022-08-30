package com.company.monthandmathservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(RandomMonthController.class)
public class RandomMonthControllerTest {

    @Autowired
    private MockMvc mockMvc;
    private ObjectMapper mapper = new ObjectMapper();

    @Test
    public void shouldReturnRandomMonthNameWithTheCorrespondingNumber() throws Exception {
        mockMvc.perform(get("/randomMonth"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void shouldReturnErrorMessageIfThePathIsDifferent() throws Exception {
        mockMvc.perform(get("/randomMonth/1"))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    public void contextLoads() {

    }

}