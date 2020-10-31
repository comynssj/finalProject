package com.easyinventory.enterprise.dao;

import com.easyinventory.enterprise.dto.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Anthony Nagal
 * This repository handles the categories
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    List<Category> findAll();
    Category getCategoryByCategoryId(int id);
    Category save(Category category);
    void deleteCategoryByCategoryId(int id);
}
