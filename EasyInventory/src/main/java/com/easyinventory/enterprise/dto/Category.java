package com.easyinventory.enterprise.dto;

import lombok.Data;
import javax.persistence.*;
/**
 * Author: Anthony Nagal
 *
 *This class is an entity for the category object
 */
@Entity
@Data
@Table(name="category_table")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="category_id", unique = true)
    private Integer categoryId;
    @Column(name="category_name")
    private String categoryName;
}
