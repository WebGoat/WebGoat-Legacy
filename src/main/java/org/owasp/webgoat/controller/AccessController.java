/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.owasp.webgoat.controller;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author rlawson, Lee Simon
 */
@Controller
public class AccessController {

    public static final String LOG_OUT_MESSAGE = "You've been logged out successfully.";
    private final Logger logger = LoggerFactory.getLogger(AccessController.class);

    @RequestMapping(value = "login.mvc", method = RequestMethod.GET)
    public ModelAndView login(
            @RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "logout", required = false) String logout) {
        return createModelAndView(error, logout, "login");
    }

    @RequestMapping(value = "logout.mvc", method = RequestMethod.GET)
    public ModelAndView logout(
            @RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "logout", required = false) String logout) {
        logger.info("Logging user out");
        return createModelAndView(error, logout, "logout");
    }

    private ModelAndView createModelAndView(String error, String logout, String viewName) {
        ModelAndView modelAndView = new ModelAndView(viewName);
        if (StringUtils.isNotEmpty(error)) {
            modelAndView.addObject("error", "Invalid username and password!");
        }
        if (StringUtils.isNotEmpty(logout)) {
            modelAndView.addObject("msg", LOG_OUT_MESSAGE);
        }
        return modelAndView;
    }
    
}
