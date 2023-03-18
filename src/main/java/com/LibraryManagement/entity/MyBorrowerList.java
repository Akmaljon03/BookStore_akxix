package com.LibraryManagement.entity;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MyBorrowers")
public class MyBorrowerList {

    @Id
    private int id;
    private String name;
    private String email;
    private int phone_number;

    public MyBorrowerList() {}

    public MyBorrowerList(int id, String name, String email, int phone_number) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone_number = phone_number;
    }

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public String getEmail() {return email;}

    public void setEmail(String email) {this.email = email;}

    public int getPhone_number() {return phone_number;}

    public void setPhone_number(int phone_number) {this.phone_number = phone_number;}
}
