package com.erovoutika.systems.entities;

import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * OrderEntity
 */
@Entity
@Table(name="orders")
public class OrderEntity {


    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="orderId")
    private int orderId;

    @Column(name="uuid")
    private String uuid;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="productId")
    private products productId;

    @Column(name="orderQuantity")
    private int orderQuantity;

    @Column(name="price")
    private int price;

 
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="userId")
    private userModel userId;

    public int getOrderId() {
        return this.orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }


    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getUuid() {
        return this.uuid;
    }

    public void setUuID(String uuID) {
        this.uuid = uuID;
    }

    public products getProductId() {
        return this.productId;
    }

    public void setProductId(products productId) {
        this.productId = productId;
    }

    public int getOrderQuantity() {
        return this.orderQuantity;
    }

    public void setOrderQuantity(int orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

   

    public userModel getUserId() {
        return this.userId;
    }

    public void setUserId(userModel userId) {
        this.userId = userId;
    }
    public OrderEntity(){

    }

}