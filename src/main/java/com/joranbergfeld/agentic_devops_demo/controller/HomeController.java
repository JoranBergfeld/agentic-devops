package com.joranbergfeld.agentic_devops_demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final Logger log = LoggerFactory.getLogger(HomeController.class);

    @GetMapping("/")
    public String index() {
        log.info("Home page requested");
        return "index";
    }
}
