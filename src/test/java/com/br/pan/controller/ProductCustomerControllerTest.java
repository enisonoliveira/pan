package com.br.pan.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.br.pan.vo.ClienteRequestSave;
import com.br.pan.vo.EnderecoRequestResponse;
import com.br.pan.vo.ProdutoClienteRequestResponse;
import com.br.pan.vo.ProdutoRequestResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
public class ProductCustomerControllerTest {
    
    private MockMvc mockMvc;

    @Autowired
    private ProductCustomerController controller;

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
        EnderecoRequestResponse address = new EnderecoRequestResponse();
        address.setCep("18070090");
        address.setUf("SP");
        address.setNumero(133123);
        address.setNumeroIBGEMunicipio("160030312");
        ClienteRequestSave customer = new ClienteRequestSave("Enison", "31231230", address);
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(customer);

        mockMvc.perform(post("/customer/save").contentType(MediaType.APPLICATION_JSON)
                .content(requestJson))
                .andExpect(status().isCreated());
                
        
        mapper = new ObjectMapper();
        ProdutoRequestResponse product = new ProdutoRequestResponse();
        product.setProducName("cartao");
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ow = mapper.writer().withDefaultPrettyPrinter();
        requestJson = ow.writeValueAsString(product);

    
        mockMvc.perform(post("/product/save").contentType(MediaType.APPLICATION_JSON)
        .content(requestJson))
        .andExpect(status().isCreated());
        
        mapper = new ObjectMapper();
        ProdutoClienteRequestResponse productCustomer = new ProdutoClienteRequestResponse();
        productCustomer.setCustomerId(1L);
        productCustomer.setProducId(1L);
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ow = mapper.writer().withDefaultPrettyPrinter();
        requestJson = ow.writeValueAsString(productCustomer);

        mockMvc.perform(post("/product/customer/save").contentType(MediaType.APPLICATION_JSON)
        .content(requestJson))
        .andExpect(status().isCreated());
    }

}
