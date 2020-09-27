package com.erovoutika.systems.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="schedules")
public class ScheduleEntity {


    @Id
	  @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;


    @Column(name="date")
    private String date;

    @Column(name="time")
    private String time;

    @Column(name="caption")
    private String caption;

    @Column(name="eventDescription")
    private String eventDescription;

    public String getEventDescription() {
      return this.eventDescription;
    }

    public void setEventDescription(String eventDescription) {
      this.eventDescription = eventDescription;
    }

    public String getTime() {
      return this.time;
    }

    public void setTime(String time) {
      this.time = time;
    }

    public String getCaption() {
      return this.caption;
    }

    public void setCaption(String caption) {
      this.caption = caption;
    }
 
  
    public String getDate() {
      return date;
    }

    public void setDate(String date) {
      this.date= date;
    }
  
  
}