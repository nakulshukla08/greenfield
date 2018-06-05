package com.empmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.empmanagement.service.LoginService;

@Controller
public class LoginController {

    @Autowired
    LoginService loginService;

    @RequestMapping(method = RequestMethod.GET, value = "/login")
    public String getLogin(final ModelMap model) {

        System.out.println("In getLogin method of Login Controller");
        return "login";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public String postLogin(final ModelMap model, @RequestParam final String username, @RequestParam final String password) {

        System.out.println("In postLogin method of Login Controller");
        if (this.loginService.validateLogin(username, password)) {
            return "welcome";
        } else {
            model.put("errormessage", "Invalid Credentials..Try again..");
            return "login";
        }
    }
}
