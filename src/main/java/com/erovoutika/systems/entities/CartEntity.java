package com.erovoutika.systems.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * OrdersEntity
 */
@Entity
@Table(name="cart")
public class CartEntity {

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name="id")
private int id;

@OneToOne(cascade = CascadeType.ALL)
@JoinColumn(name="productId")
private products productId;

public products getProductId() {
    return this.productId;
}

public void setProductId(products productId) {
    this.productId = productId;
}

@Column(name="orderQuantity")
private int orderQuantity;

@OneToOne(cascade = CascadeType.ALL)
@JoinColumn(name="userId")
private userModel userId;

public userModel getUserId() {
    return this.userId;
}

public void setUserId(userModel userId) {
    this.userId = userId;
}

public int getOrderQuantity() {
    return this.orderQuantity;
}

public void setOrderQuantity(int orderQuantity) {
    this.orderQuantity = orderQuantity;
}

public int getId() {
    return this.id;
}

public void setId(int id) {
    this.id = id;
}


public CartEntity(){}

public CartEntity(int orderQuantity) {
this.orderQuantity=orderQuantity;
}
}