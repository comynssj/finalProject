package com.easyinventory.enterprise.dto;

import lombok.Data;
import javax.persistence.*;

/**
 * Author: Anthony Nagal
 *
 * This class is an entity for the item object
 */
@Entity
@Data
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
}
