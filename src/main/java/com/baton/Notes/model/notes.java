package com.baton.Notes.model;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.w3c.dom.Text;

import javax.persistence.*;
import java.sql.Date;
@Entity
@Table(name = "notes")
public class notes {
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String note;




    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }


    public Date getCreated_on() {
        return created_on;
    }

    public void setCreated_on(Date created_on) {

        this.created_on = this.created_on;
    }


    public Boolean getIs_active() {
        return is_active;
    }

    public void setIs_active(Boolean is_active) {
        this.is_active = is_active;
    }
    @CreationTimestamp
    private Date created_on;
    private Boolean is_active;


}
