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
 * authorities
 */
@Entity
@Table(name="authorities")
public class authorities {
    

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name="email")
    private String email;


    @Column(name="authority")
    private String authority;

    // @OneToOne(cascade = CascadeType.ALL,mappedBy = "authority")
    // private userModel user;

    public String getEmail() {
        return this.email;
    }
   

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAuthority() {
        return this.authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public authorities(){}

    public authorities(String email, String authority) {
        this.email=email;
        this.authority=authority;
    }
    
    
}