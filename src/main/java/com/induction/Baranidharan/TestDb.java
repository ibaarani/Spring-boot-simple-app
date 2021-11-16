package com.induction.Baranidharan;

import lombok.Data;
import org.apache.catalina.User;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "students")
public class TestDb {
    @Id
    //@GeneratedValue

    // auto matic generation of id needs to be fixed
    private Integer id;

    private String name;
    private String email;
    @ManyToOne
    private TestDb testDb;


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