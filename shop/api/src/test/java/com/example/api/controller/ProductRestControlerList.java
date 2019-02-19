package com.example.api.controller;

import com.example.api.model.Product;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.lang.reflect.Array;
import java.util.Arrays;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
@RunWith(SpringRunner.class)
@WebMvcTest(ProductController.class)
public class ProductRestControlerList {
    Product product;
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testShowUsersResourceList() throws Exception {
         mockMvc.perform(
                 get("/api/products")
                .accept(MediaType.APPLICATION_JSON))
                 .andExpect(status().isOk())
                 .andExpect(content()
                         .contentType("application/json;charset=UTF-8"))
                            .andExpect(jsonPath("$[0].name")
                         .value("product 1"));
    }
    @Test
    public void testShowUsersResourceList2() throws Exception {
        mockMvc.perform(
                get("/api/products")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$.length()")
                        .value(2))
                .andExpect(jsonPath("$[0].images.length()")
                        .value(2))
                .andExpect(jsonPath("$[1].images.length()")
                        .value(2))
        ;
    }
}
