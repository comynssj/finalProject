package com.easyinventory.enterprise.controller;
import com.easyinventory.enterprise.dto.Category;
import com.easyinventory.enterprise.dto.Item;
import com.easyinventory.enterprise.service.EasyInventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Author: Anthony Nagal
 *
 * This class is the EasyInventoryController, It will control
 * the two repositories where the data will be gotten from/manipulated
 *
 */
@RestController
@RequestMapping("/service")
public class EasyInventoryController {

    @Autowired
    EasyInventoryService easyInventoryService;

    //Endpoints for the categories

    //Retrieves all the categories from the database
    @RequestMapping(value="/category/all", method = RequestMethod.GET)
    public List<Category> getAllCategories(){
        return easyInventoryService.getAllCategories();
    }

    @RequestMapping(value="/category/{id}", method = RequestMethod.GET)
    public Category getAllCategories(@RequestParam int id) throws Exception {
        return easyInventoryService.getCategoryByCategoryId(id);
    }

    //Adds a new value to the category table
    @RequestMapping(value="/category/newcategory", method = RequestMethod.POST)
    public Category addCategory(@RequestBody Category category) throws Exception {
        return easyInventoryService.saveCategory(category);
    }

    //Deletes a category from the table
    @RequestMapping(value="/category/deletecategory", method = RequestMethod.DELETE)
    public void deleteCategory(@RequestBody Category category) throws Exception {
        easyInventoryService.deleteCategory(category);
    }

    //Endpoints for the Items

    //Retrieves all the items from the database
    @RequestMapping(value="/item/all", method = RequestMethod.GET)
    public List<Item> getAllItems(){
        return easyInventoryService.getAllItems();
    }

    //Adds a new value to the item table
    @RequestMapping(value="/item/newitem", method = RequestMethod.POST)
    public Item addItem(@RequestBody Item item) throws Exception {
        return easyInventoryService.saveItem(item);
    }

    //Deletes a new value to the item table
    @RequestMapping(value="/item/newitem", method = RequestMethod.DELETE)
    public void deleteItem(@RequestBody Item item) throws Exception {
        easyInventoryService.deleteItem(item);
    }
}
