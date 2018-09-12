package org.csu.tshirt.domain;

import java.math.BigDecimal;

public class Item {
    private String itemId;
    private String itemName;
    private String itemImage;
    private String itemColor;
    private Product product;
    private int quantity;


    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemImage() {
        return itemImage;
    }

    public void setItemImage(String itemImage) {
        this.itemImage = itemImage;
    }

    public String getItemColor() {
        return itemColor;
    }

    public void setItemColor(String item_color) {
        this.itemColor = item_color;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
