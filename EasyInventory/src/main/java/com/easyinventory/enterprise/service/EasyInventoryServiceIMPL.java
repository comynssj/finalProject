package com.easyinventory.enterprise.service;

import com.easyinventory.enterprise.dao.CategoryRepository;
import com.easyinventory.enterprise.dao.ItemRepository;
import com.easyinventory.enterprise.dto.Category;
import com.easyinventory.enterprise.dto.Item;
import javassist.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EasyInventoryServiceIMPL implements EasyInventoryService{

    private ItemRepository itemRepository;

    private CategoryRepository categoryRepository;

    private Logger log = LoggerFactory.getLogger(this.getClass());

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
        try {
            log.info(category + "was saved");
            return categoryRepository.save(category);
        }
        catch (Exception e) {
            log.error("Unhandled exception: " + e.getMessage());
            return null;
        }
    }

    /**
     * @param category Category to delete
     * @return boolean outcome
     * @throws Exception category doesn't exist or couldn't be deleted because items exist
     */
    @Override
    public void deleteCategory(Category category) throws Exception {
        int categoryId = category.getCategoryId();
        try {
            categoryRepository.deleteCategoryByCategoryId(categoryId);
            log.info("Deleted category by ID: " + categoryId);
        }
        catch (Exception e) {
            log.error("Unhandled exception: " + e.getMessage());
        }
    }

    /**
     * @param id
     * @return category
     * @throws Exception category doesn't exist or couldn't be gotten
     */
    @Override
    public Category getCategoryByCategoryId(int id) throws Exception {
        try {
            return categoryRepository.getCategoryByCategoryId(id);
        } catch (Exception e) {
            log.error("Unhandled exception: " + e.getMessage());
            return null;
        }

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
        try {
            log.info("Saved item: " + item);
            return itemRepository.save(item);
        } catch (Exception e) {
            log.error("Unhandled exception: " + e.getMessage());
            return null;
        }

    }



    /**
     * @param item Item to be deleted
     * @throws Exception Item could not be deleted
     */
    @Override
    public void deleteItem(Item item) throws Exception {
        try {
            itemRepository.deleteByItemIdAndAndCategoryId(item.getItemId(), item.getCategoryId());
            log.info("Item deleted by ItemID and CategoryID: ItemID " + item.getItemId() + " CategoryID: " + item.getCategoryId());
        } catch (Exception e) {
            log.error("Unhandled exception: " + e.getMessage());
        }
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

    /**
     * @return item by item id
     */
    @Override
    public Item findItemByItemId(int id){ return itemRepository.findItemByItemId(id); }
}
