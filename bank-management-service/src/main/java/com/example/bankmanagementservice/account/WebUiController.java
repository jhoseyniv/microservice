package com.example.bankmanagementservice.account;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@RestController
public class WebUiController implements WebMvcConfigurer   {

    @GetMapping("/home_bank")
    @ResponseBody
    public ModelAndView showHome() {
        ModelAndView mav = new ModelAndView("home");
        return mav;
    }

}
