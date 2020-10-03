package com.erovoutika.systems.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

/**
 * TheCart
 */
@Entity
@Table(name = "TheCart")
public class TheCart {
    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    
    @Column(name="productDescription")
    private String productDescription;

    @Column(name="remainingQuantity")
    private int remainingQuantity;

    @Column(name="productPrice")
    private int productPrice;

    @Column(name="productImageLocation")
    private String productImageLocation;

    @Column(name="orderQuantity")
    private int orderQuantity;

    @Column(name="userId")
    private int userId;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductDescription() {
        return this.productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public int getRemainingQuantity() {
        return this.remainingQuantity;
    }

    public void setRemainingQuantity(int remainingQuantity) {
        this.remainingQuantity = remainingQuantity;
    }

    public int getProductPrice() {
        return this.productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductImageLocation() {
        return this.productImageLocation;
    }

    public void setProductImageLocation(String productImageLocation) {
        this.productImageLocation = productImageLocation;
    }

    public int getOrderQuantity() {
        return this.orderQuantity;
    }

    public void setOrderQuantity(int orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    public int getUserId() {
        return this.userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public TheCart(){}

}