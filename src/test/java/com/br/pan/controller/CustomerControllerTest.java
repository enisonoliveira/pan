package com.br.pan.controller;

import static org.assertj.core.api.Assertions.assertThat;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.br.pan.service.CustomerService;
import com.br.pan.vo.ClienteRequestSave;
import com.br.pan.vo.ClienteRequestUpdate;
import com.br.pan.vo.EnderecoRequestResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
public class CustomerControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private CustomerController controller;

    @Autowired
    private CustomerService customerService;

    @Test
    void contextLoads() throws Exception {
        assertThat(controller).isNotNull();
    }

    @BeforeEach
    public void setUp(WebApplicationContext webApplicationContext) throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
                .build();

    }

    @Test
    void shouldReturnCustomerMessage() throws Exception {
        try {
            customerService.delete("31231230");
        } catch (Exception e) {
        }

        ObjectMapper mapper = new ObjectMapper();
        EnderecoRequestResponse address = new EnderecoRequestResponse();
        address.setCep("18070090");
        address.setUf("SP");
        address.setNumeroIBGEMunicipio("160030312");
        ClienteRequestSave customer = new ClienteRequestSave("Enison", "31231230", address);
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(customer);

        mockMvc.perform(post("/customer/save").contentType(MediaType.APPLICATION_JSON)
                .content(requestJson))
                .andExpect(status().isCreated());

  
         mapper = new ObjectMapper();
        address.setCep("18070090");
        address.setUf("SP");
        ClienteRequestUpdate customerUpdate = new ClienteRequestUpdate( "31231230", address);
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
         ow = mapper.writer().withDefaultPrettyPrinter();
         requestJson = ow.writeValueAsString(customerUpdate);

        mockMvc.perform(put("/customer/edit/address").contentType(MediaType.APPLICATION_JSON)
                .content(requestJson))
                .andExpect(status().isOk());

    }

    @Test
    void shouldSaveCustomerMessage() throws Exception {
        this.mockMvc.perform(get("/customer/search/31231230")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("")));
    }
}
