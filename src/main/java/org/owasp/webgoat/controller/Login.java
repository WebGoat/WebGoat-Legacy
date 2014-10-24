/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.owasp.webgoat.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author rlawson
 */
@Controller
public class Login {

    @RequestMapping(value = "login.mvc", method = RequestMethod.GET)
    public ModelAndView login(
            @RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "logout", required = false) String logout) {

        ModelAndView modelAndView = new ModelAndView("login");
        if (StringUtils.isNotEmpty(error)) {
            modelAndView.addObject("error", "Invalid username and password!");
        }
        if (StringUtils.isNotEmpty(logout)) {
            modelAndView.addObject("msg", "You've been logged out successfully.");
        }
        return modelAndView;
    }
}
