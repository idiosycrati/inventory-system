package com.erovoutika.systems.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * products
 */
@Entity
@Table(name="products")
public class products {   
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="productDescription")
    private String productDescription;

    @Column(name="productName")
    private String productName;

  
    @Column(name="remainingQuantity")
    private int remainingQuantity;

    @Column(name="productPrice")
    private int productPrice;

    @Column(name="productImageLocation")
    private String productImageLocation;

    @Column(name="enabled")
    private int enabled;

    public int getEnablded() {
        return this.enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    public String getProductImageLocation() {
        return this.productImageLocation;
    }

    public void setProductImageLocation(String productImageLocation) {
        this.productImageLocation = productImageLocation;
    }


    public int getProductPrice() {
        return this.productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

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
    public String getProductName() {
        return this.productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }


  public products(){

  }

  public products(String productDescription,int productPrice,int remainingQuantity){
      this.productDescription=productDescription;
      this.remainingQuantity=remainingQuantity;
      this.productPrice=productPrice;
}
// @Override
// public String toString(){
//     return "{\"productDescription\" :"+"\""+getProductDescription()+"\""+"}";
// }
}