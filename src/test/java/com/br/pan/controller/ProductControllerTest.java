package com.br.pan.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.AutoConfigureDataJdbc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.br.pan.vo.ProdutoRequestResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;

@SpringBootTest
@AutoConfigureDataJdbc
public class ProductControllerTest {
    
    private MockMvc mockMvc;

    @Autowired
    private ProductController controller;


    @Test
    void contextLoads() throws Exception {
        assertThat(controller).isNotNull();
    }

    @BeforeEach
    void setUp(WebApplicationContext webApplicationContext) throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
                .build();

    }

    @Test
    void testSave() throws Exception{

        ObjectMapper mapper = new ObjectMapper();
        ProdutoRequestResponse product = new ProdutoRequestResponse();
        product.setProducName("cartao");
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(product);

   
        mockMvc.perform(post("/product/save").contentType(MediaType.APPLICATION_JSON)
        .content(requestJson))
        .andExpect(status().isCreated());

        product.setId(1L);
        mockMvc.perform(put("/product/update").contentType(MediaType.APPLICATION_JSON)
        .content(requestJson))
        .andExpect(status().isCreated());
    }

}
