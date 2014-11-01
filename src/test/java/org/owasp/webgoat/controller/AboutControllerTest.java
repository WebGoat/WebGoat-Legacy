package org.owasp.webgoat.controller;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

public class AboutControllerTest {
    
    private AboutController controller;

    @Test
    public void testAboutController() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        controller = new AboutController();
        ModelAndView modelAndView = controller.welcome(request);
        assertEquals("about", modelAndView.getViewName());
        assertNotNull(request.getSession().getAttribute("welcomed"));
        assertTrue(request.getSession().getAttribute("welcomed").equals("true"));
    }
}
