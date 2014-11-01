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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@ContextConfiguration(locations={"/mvc-dispatcher-servlet.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "web")
public class AccessControllerTest {

    @Autowired
    private WebApplicationContext wac;
    private MockMvc mvc;
    private final String LOGIN_URL = "/login.mvc";
    private final String LOGOUT_URL = "/logout.mvc";

    @Before
    public void setUp(){
        mvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void testLogin() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = createRequest(LOGIN_URL);
        requestBuilder.param("error", "an error");
        requestBuilder.param("logout", "logout model attribute");
        ResultActions result = mvc.perform(requestBuilder);
        checkView(result, "login");
        checkModel(result);
    }
    
    @Test
    public void testLoginWithoutError() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = createRequest(LOGIN_URL);
        ResultActions result = mvc.perform(requestBuilder);
        checkView(result, "login");
        Map<String, Object> model = result.andReturn().getModelAndView().getModel();
        assertFalse(model.containsKey("error"));
    }
    
    @Test
    public void testLogout() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = 
                createRequest(LOGOUT_URL);
        requestBuilder.param("logout", "logout");
        ResultActions result = mvc.perform(requestBuilder);
        checkView(result, "logout");
        Map<String, Object> model = result.andReturn().getModelAndView().getModel();
        assertTrue(model.containsKey("msg"));
        assertEquals(AccessController.LOG_OUT_MESSAGE,model.get("msg"));
    }

    private MockHttpServletRequestBuilder createRequest(String url) {
        MockHttpServletRequestBuilder requestBuilder =
                MockMvcRequestBuilders.get(url);
        return requestBuilder;
    }

    private void checkModel(ResultActions result) {
        Map<String, Object> model = result.andReturn().getModelAndView().getModel();
        assertNotNull(model);
        assertTrue(model.containsKey("error"));
        assertTrue(model.containsKey("msg"));
    }

    private void checkView(ResultActions result, String viewName) throws Exception {
        result.andExpect(status().isOk()).andExpect(view().name(viewName));
    }
}