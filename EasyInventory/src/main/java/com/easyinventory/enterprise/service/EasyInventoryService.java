package com.easyinventory.enterprise.service;

import com.easyinventory.enterprise.dto.Category;
import com.easyinventory.enterprise.dto.Item;

import java.util.List;

public interface EasyInventoryService {
    Category saveCategory(Category category) throws Exception;
    void deleteCategory(Category category) throws Exception;
    Category getCategoryByCategoryId(int id) throws Exception;
    List<Category> getAllCategories();
    Item saveItem(Item item) throws Exception;
    void deleteItem(Item item) throws Exception;
    List<Item> getAllItems();
    List<Item> getItemsByCategory(int id);
    }
