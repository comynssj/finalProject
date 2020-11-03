package com.easyinventory.enterprise.controller;

import com.easyinventory.enterprise.dto.Category;
import com.easyinventory.enterprise.dto.Item;
import com.easyinventory.enterprise.service.EasyInventoryService;
import org.springframework.beans.factory.annotation.Autowired;
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
    private EasyInventoryService easyInventoryService;
    //Endpoints for the categories

    //Retrieves all the categories from the database
    @GetMapping("/category/all")
    public List<Category> getAllCategories(Model model){
        return easyInventoryService.getAllCategories();
    }

    @GetMapping("/category/{id}")
    public Category getCategoryById(@PathVariable int id, Model model) throws Exception {
        Category category = easyInventoryService.getCategoryByCategoryId(id);
        model.addAttribute("singleCategory", category);
        return easyInventoryService.getCategoryByCategoryId(id);
    }

    //Adds a new value to the category table
    @PostMapping("/category/newcategory")
    public Category addCategory(@RequestBody Category category) throws Exception {
        return easyInventoryService.saveCategory(category);
    }

    //Deletes a category from the table
    @DeleteMapping("/category/deletecategory")
    public void deleteCategory(@RequestBody Category category) throws Exception {
        easyInventoryService.deleteCategory(category);
    }

    //Endpoints for the Items

    //Retrieves all the items from the database
    @GetMapping("/item/all")
    public List<Item> getAllItems(){
        List<Item> itemList = easyInventoryService.getAllItems();
        return itemList;
    }

    //Retrieves all the items from the database by category id
    @GetMapping("/item/{id}")
    public List<Item> getItemsByCategory(@PathVariable int id){
        List<Item> itemList = easyInventoryService.getItemsByCategory(id);
        return itemList;
    }

    //Retrieves an item by item id
    @RequestMapping(value="/item/item/{id}")
    public Item getItemByItemId(@PathVariable int id, Model model){
        Item item = easyInventoryService.findItemByItemId(id);
        model.addAttribute("selectedItem", item);
        return item;
    }

    //Adds a new value to the item table
    @PostMapping("/item/newitem")
    public Item addItem(@RequestBody Item item) throws Exception {
        return easyInventoryService.saveItem(item);
    }

    //Deletes a new value to the item table
    @DeleteMapping("/item/deleteitem")
    public void deleteItem(@RequestBody Item item) throws Exception {
        easyInventoryService.deleteItem(item);
    }
}
