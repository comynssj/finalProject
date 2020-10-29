package com.easyinventory.enterprise.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Author: Anthony Nagal
 *
 *This controller serves the html pages through thymeleaf
 */
@Controller
public class HTMLController {

    @RequestMapping(name="/")
    public String index(){
        return "start";
    }
}
