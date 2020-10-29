package com.easyinventory.enterprise.controller;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Author: Anthony Nagal
 *
 *This controller serves the html pages through thymeleaf
 */
@Controller
@SpringBootApplication
public class HTMLController {

    @RequestMapping(value="/")
    public String index(){
        return "start";
    }

    @RequestMapping(value="/inventory")
    public String inventory(){
        return "inventory";
    }
}
