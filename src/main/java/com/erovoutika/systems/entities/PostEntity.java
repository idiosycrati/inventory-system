package com.erovoutika.systems.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="posts")
public class PostEntity {


    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="postCaption")
    private String postCaption;

    @Column(name="postBanner")
    private String postBanner;

    @Column(name="enabled")
    private int enabled;

    public int getEnabled() {
        return this.enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPostCaption() {
        return this.postCaption;
    }

    public void setPostCaption(String postCaption) {
        this.postCaption = postCaption;
    }

    public String getPostBanner() {
        return this.postBanner;
    }

    public void setPostBanner(String postBanner) {
        this.postBanner = postBanner;
    }

}
