package com.easyinventory.enterprise.dto;

import lombok.Data;

public @Data class Item {

    private Integer itemId;
    private Integer categoryId;
    private String itemName;
    private Integer itemQuantity;
    private String itemNotes;
}
