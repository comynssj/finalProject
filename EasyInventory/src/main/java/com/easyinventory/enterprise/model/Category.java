package com.easyinventory.enterprise.model;

import javax.persistence.*;
/**
 * Author: Anthony Nagal
 *
 *This class is an entity for the category object
 */
@Entity
@Table(name="category_table")

@Data
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name="category_id", unique = true)
    private Integer categoryId;
    @Column(name="category_name")
    private String categoryName;

    public Category(){}

    public Category(Integer categoryId, String categoryName){
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
