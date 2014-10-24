package org.owasp.webgoat.controller;

import java.util.Map;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ContextConfiguration(locations={
        "/mvc-dispatcher-servlet.xml"
})
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "web")
public class LoginTest {

    @Autowired
    private WebApplicationContext wac;
    private MockMvc mvc;

    @Before
    public void setUp(){
        mvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void testLogin() throws Exception {
        MockHttpServletRequestBuilder requestBuilder =
                MockMvcRequestBuilders.get("/login.mvc");
        requestBuilder.param("error", "an error");
        requestBuilder.param("logout", "logout model attribute");
        ResultActions result = mvc.perform(requestBuilder);
        checkView(result);
        checkModel(result);
    }

    private void checkModel(ResultActions result) {
        Map<String, Object> model = result.andReturn().getModelAndView().getModel();
        assertNotNull(model);
        assertTrue(model.containsKey("error"));
        assertTrue(model.containsKey("msg"));
    }

    private void checkView(ResultActions result) throws Exception {
        result.andExpect(status().isOk())
        .andExpect(MockMvcResultMatchers.view().name("login"));
    }
}