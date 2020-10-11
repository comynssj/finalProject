package com.easyinventory.enterprise.repository;

import com.easyinventory.enterprise.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import static org.hibernate.loader.Loader.SELECT;


/**
 * Author: Anthony Nagal
 *
 * This is the repository for the Categories. It will talk to the database and hold the data
 * in java persistence
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    /**
     * Ensures the categories are sorted correctly, future-proofing but most-likely redundant.
     * @return
     */
    List<Category> findAllByOrderByCategoryIdAsc();
}
