package com.sapient.productcatalogue.controller;

import com.sapient.productcatalogue.ProductCatalogueBaseTest;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class BrandControllerTests extends ProductCatalogueBaseTest {
    @Rule
    public ExpectedException expected = ExpectedException.none();

    @Test
    public void test01getBrandById() throws Exception {
        MockHttpServletRequestBuilder requestBuilder =  MockMvcRequestBuilders.get("/api/brands/");
        MvcResult result = mockMvc.perform(requestBuilder)
                .andExpect(status().is(HttpStatus.OK.value()))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        assertNotNull(result);
    }
}
