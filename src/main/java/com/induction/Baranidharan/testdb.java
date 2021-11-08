package com.induction.Baranidharan;

import javax.persistence.*;

@Entity
@Table(name = "students")
public class testdb {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)

    // auto matic generation of id needs to be fixed
    private Integer id;

    private String name;
    private String email;



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

    // getters and setters...
    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", email=" + email + "]";
    }
}