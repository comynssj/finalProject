package com.easyinventory.enterprise.service;

import com.easyinventory.enterprise.dao.CategoryRepository;
import com.easyinventory.enterprise.dao.ItemRepository;
import com.easyinventory.enterprise.dto.Category;
import com.easyinventory.enterprise.dto.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EasyInventoryServiceIMPL implements EasyInventoryService{

    ItemRepository itemRepository;

    CategoryRepository categoryRepository;

    @Autowired
    public EasyInventoryServiceIMPL(CategoryRepository categoryRepository, ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
        this.categoryRepository = categoryRepository;
    }

    /**
     * @param category Category to save
     * @return Saved Category
     * @throws Exception Category doesn't exist
     */
    @Override
    public Category saveCategory(Category category) throws Exception {
        return categoryRepository.save(category);
    }

    /**
     * @param category Category to delete
     * @return boolean outcome
     * @throws Exception category doesn't exist or couldn't be deleted because items exist
     */
    @Override
    public void deleteCategory(Category category) throws Exception {
        int categoryId = category.getCategoryId();
        categoryRepository.deleteCategoryByCategoryId(categoryId);
    }

    /**
     * @param id
     * @return category
     * @throws Exception category doesn't exist or couldn't be gotten
     */
    @Override
    public Category getCategoryByCategoryId(int id) throws Exception {
        return categoryRepository.getCategoryByCategoryId(id);
    }

    /**
     * @return List of all Categories
     */
    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    /**
     * @param item Item to save
     * @return item that was saved
     * @throws Exception Item could not be saved
     */
    @Override
    public Item saveItem(Item item) throws Exception {
        return itemRepository.save(item);
    }



    /**
     * @param item Item to be deleted
     * @throws Exception Item could not be deleted
     */
    @Override
    public void deleteItem(Item item) throws Exception {
        itemRepository.deleteByItemIdAndAndCategoryId(item.getItemId(), item.getCategoryId());
    }

    /**
     * @return list of all items
     */
    @Override
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }
    /**
     * @return list of all items
     */
    @Override
    public List<Item> getItemsByCategory(int id) {
        return itemRepository.findItemsByCategoryId(id);
    }
}
