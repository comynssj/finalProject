package com.easyinventory.enterprise.controller;

import com.easyinventory.enterprise.model.Category;
import com.easyinventory.enterprise.model.Item;
import com.easyinventory.enterprise.repository.CategoryRepository;
import com.easyinventory.enterprise.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.ArrayList;
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
    CategoryRepository categoryRepository;

    @Autowired
    ItemRepository itemRepository;

    //Endpoints for the categories

    //Retrieves all the categories from the database
    @RequestMapping(value="/category/all", method = RequestMethod.GET)
    public List<Category> getAllCategories(){
        return categoryRepository.findAllByOrderByCategoryIdAsc();
    }

    //Adds a new value to the category table
    @RequestMapping(value="/category/newcategory", method = RequestMethod.POST)
    public List<Category> addCategory(@RequestBody Category category){
        categoryRepository.saveAndFlush(category);
        List<Category> categoryList;
        categoryList = categoryRepository.findAllByOrderByCategoryIdAsc();
        return categoryList;
    }

    //Deletes a category from the table
    @RequestMapping(value="/category/deletecategory", method = RequestMethod.DELETE)
    public List<Category> deleteCategory(@RequestBody Category category){
        categoryRepository.delete(category);
        categoryRepository.flush();
        List<Category> categoryList;
        categoryList = categoryRepository.findAllByOrderByCategoryIdAsc();
        return categoryList;
    }


    //Endpoints for the Items

    //Retrieves all the items from the database
    @RequestMapping(value="/item/all", method = RequestMethod.GET)
    public List<Item> getAllItems(){
        return itemRepository.findAllByOrderByCategoryIdAsc();
    }

    //Adds a new value to the item table
    @RequestMapping(value="/item/newitem", method = RequestMethod.POST)
    public List<Item> addItem(@RequestBody Item item){
        itemRepository.saveAndFlush(item);
        List<Item> itemList;
        itemList = itemRepository.findAllByOrderByCategoryIdAsc();
        return itemList;
    }

    //Deletes a new value to the item table
    @RequestMapping(value="/item/newitem", method = RequestMethod.DELETE)
    public List<Item> deleteItem(@RequestBody Item item){
        itemRepository.delete(item);
        List<Item> itemList;
        categoryRepository.flush();
        itemList = itemRepository.findAllByOrderByCategoryIdAsc();
        return itemList;
    }
}
