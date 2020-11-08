package com.easyinventory.enterprise.controller;

import com.easyinventory.enterprise.dto.Category;
import com.easyinventory.enterprise.dto.Item;
import com.easyinventory.enterprise.service.EasyInventoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Anthony Nagal
 *
 * This controller will handle calls that are not directly needed or might be needed from the HTML.
 */
@RestController
public class EasyInventoryController {

    @Autowired
    EasyInventoryService easyInventoryService;
    //Endpoints for the categories

    Logger log = LoggerFactory.getLogger(this.getClass());

    //Retrieves all the categories from the database
    @GetMapping(value="/category/all")
    public List<Category> getAllCategories(Model model){
        return easyInventoryService.getAllCategories();
    }

    @GetMapping(value="/category/{id}")
    public Category getCategoryById(@PathVariable int id, Model model) throws Exception {
        Category category = easyInventoryService.getCategoryByCategoryId(id);
        model.addAttribute("singleCategory", category);
        return easyInventoryService.getCategoryByCategoryId(id);
    }

    //Adds a new value to the category table
    @PostMapping(value="/category/newcategory")
    public Category addCategory(@RequestBody Category category) throws Exception {
        return easyInventoryService.saveCategory(category);
    }

    //Deletes a category from the table
    @DeleteMapping(value="/category/deletecategory")
    public void deleteCategory(@RequestBody Category category) throws Exception {

        log.debug("Entering delete category endpoint");

        easyInventoryService.deleteCategory(category);
        log.info("Category " + category + "was deleted");
    }

    //Endpoints for the Items

    //Retrieves all the items from the database
    @GetMapping(value="/item/all")
    public List<Item> getAllItems(){
        return easyInventoryService.getAllItems();
    }

    //Retrieves all the items from the database by category id
    @GetMapping(value="/item/{id}")
    public List<Item> getItemsByCategory(@PathVariable int id){
        return easyInventoryService.getItemsByCategory(id);
    }

    //Retrieves an item by item id
    @GetMapping(value="/item/item/{id}")
    public Item getItemByItemId(@PathVariable int id, Model model){
        Item item = easyInventoryService.findItemByItemId(id);
        model.addAttribute("selectedItem", item);
        return item;
    }

    //Adds a new value to the item table
    @PostMapping(value="/item/newitem")
    public Item addItem(@RequestBody Item item) throws Exception {
        return easyInventoryService.saveItem(item);
    }

    //Deletes a new value to the item table
    @DeleteMapping (value="/item/deleteitem")
    public void deleteItem(@RequestBody Item item) throws Exception {

        log.debug("Entering delete category endpoint");

        easyInventoryService.deleteItem(item);
        log.info("Item " + item + "was deleted");
    }
}
