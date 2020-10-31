package com.easyinventory.enterprise.controller;

import com.easyinventory.enterprise.dto.Category;
import com.easyinventory.enterprise.dto.Item;
import com.easyinventory.enterprise.service.EasyInventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.easyinventory.enterprise.controller.EasyInventoryController;

import java.util.List;

/**
 * Author: Anthony Nagal
 *
 *This controller serves the html pages through thymeleaf
 */
@Controller
public class HTMLController {

    @Autowired
    EasyInventoryService easyInventoryService;

    @RequestMapping(value="/")
    public String index(){
        return "start";
    }

    @RequestMapping(value="/inventory")
    public String inventory(Model model){
        List<Category> categoryList = easyInventoryService.getAllCategories();
        //Adds the category list to the html template under id 'categories'
        model.addAttribute("categories",categoryList);
        return "inventory";
    }

    @RequestMapping(value="/inventory/{id}")
    public String inventoryCategory(@PathVariable int id, Model model){
        List<Item> itemList = easyInventoryService.getItemsByCategory(id);
        //Adds the item list to the html template under the id 'items'
        model.addAttribute("items", itemList);

        //The HTML page needs to be created but im not sure if it will be a new page or if it will be a window covering the main view.
        return "";
    }


}
