package com.br.pan.controller;

import static org.assertj.core.api.Assertions.assertThat;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
public class AddressControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private AddressController controller;

    @Test
    void contextLoads() throws Exception {
        assertThat(controller).isNotNull();
    }

    @BeforeEach
    public void setUp(WebApplicationContext webApplicationContext) {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
                .build();
    }

    @Test
    void shouldReturnStatsMessage() throws Exception {
        this.mockMvc.perform(get("/address/search/state")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("São Paulo")));
    }

    @Test
    void shouldReturnLocationtMessage() throws Exception {
        this.mockMvc.perform(get("/address/search?CEP=18070090")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Rua Fernão Dias Falcão")));
    }


    @Test
    void shouldReturnLocationCitytMessage() throws Exception {
        this.mockMvc.perform(get("/address/search/municipio?codigo=33")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Rio de Janeiro")));
    }
}
