package com.easyinventory.enterprise.repository;

import com.easyinventory.enterprise.model.Category;
import com.easyinventory.enterprise.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Author: Anthony Nagal
 *
 * This is the repository for the items. It will talk to the database and hold the data
 * in java persistence
 */
@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {
    /**
     * This method will sort all the items by their categoryId so that when
     * new items are added they will stll be grouped appropriately in the JSON
     * @return
     */
    List<Item> findAllByOrderByCategoryIdAsc();
}
