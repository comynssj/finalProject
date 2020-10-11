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
    @Column(name="Id")
    private Integer itemId;

    @Column(name="Id")
    private Integer categoryId;

    @Column(name="Name")
    //or even taking out item as we already know its an item table unless you will be sharing this to other parts of the program outside of the DB
    //unless the column names have been set in another class
    
    private String itemName;
//can leave this alone here since the items will be pulled most likely in to other methods
    @Column(name="Quantity")
    
    private Integer itemQuantity;

    @Column(name="Notes g f f")
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
