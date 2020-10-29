package com.easyinventory.enterprise.model;

import org.springframework.stereotype.Repository;

import javax.persistence.*;

/**
 * Author: Anthony Nagal
 *
 * This class is an entity for the item object
 */
@Entity
@Table(name="item_table")
public class Item {

    @Id
    @GeneratedValue
    @Column(name="item_id")
    private Integer itemId;

    @Column(name="category_id")
    private Integer categoryId;

    @Column(name="item_name")
    private String itemName;

    @Column(name="item_quantity")
    private Integer itemQuantity;

    @Column(name="item_notes")
    private String itemNotes;

    public Item(){}

    //Overloaded constructor for creating full items at once.
    public Item(Integer itemId, Integer categoryId, String itemName, Integer itemQuantity, String itemNotes){
        this.itemId = itemId;
        this.categoryId = categoryId;
        this.itemName = itemName;
        this.itemQuantity = itemQuantity;
        this.itemNotes = itemNotes;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }


    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Integer getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(Integer itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public String getItemNotes() {
        return itemNotes;
    }

    public void setItemNotes(String itemNotes) {
        this.itemNotes = itemNotes;
    }
}
