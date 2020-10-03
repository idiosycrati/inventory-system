package com.erovoutika.systems.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;

import com.erovoutika.systems.SystemsApplication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * userModel
 */
@Entity
@Table(name="users")
public class UserEntity {
    private static final Logger log = LoggerFactory.getLogger(SystemsApplication.class);
    // @GeneratedValue(strategy=GenerationType.IDENTITY)

    

    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

 
    // @Email
    @Column(name="email")
    private String email;

    // @Max(value=16)

    @Column(name="password")
    private String password;


    @Column(name="enabled")
    private int enabled;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="auth_id")
    private Authorities authority;


    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public Authorities getAuthority() {
        return this.authority;
    }

    public void setAuthority(Authorities authority) {
        this.authority = authority;
    }

    public int getEnabled() {
        return this.enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }   

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        // log.error(this.password);
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserEntity(){

        
    }
  
    public UserEntity(String email, String password) {
        this.email=email;
        this.password=password;
    }
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "Username: "+getEmail()+ " Password: "+getPassword();
    }

}