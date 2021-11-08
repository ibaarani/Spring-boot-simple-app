package com.induction.Baranidharan;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "students")
public class testdb {
    @Id
    //@GeneratedValue

    // auto matic generation of id needs to be fixed
    private Integer id;

    private String name;
    private String email;
    private String date;


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}