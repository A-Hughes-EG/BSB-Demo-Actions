package com.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(GreetingController.class)
public class GreetingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGreetEndpoint() throws Exception {
        mockMvc.perform(get("/api/greet/World"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello, World!"));
    }

    @Test
    public void testGreetWithDifferentName() throws Exception {
        mockMvc.perform(get("/api/greet/Developer"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello, Developer!"));
    }

    @Test
    public void testHealthEndpoint() throws Exception {
        mockMvc.perform(get("/api/health"))
                .andExpect(status().isOk())
                .andExpect(content().string("API is healthy"));
    }
}
