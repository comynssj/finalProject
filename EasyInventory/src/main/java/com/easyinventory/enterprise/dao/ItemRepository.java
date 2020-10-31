package com.easyinventory.enterprise.dao;

import com.easyinventory.enterprise.dto.Category;
import com.easyinventory.enterprise.dto.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Anthony Nagal
 * This repository handles the Items
 */
@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {
    List<Item> findAll();
    List<Item> findItemsByCategoryId(int categoryID);
    Item save(Item item);
    void deleteByItemIdAndAndCategoryId(int itemID, int categoryID);
}
