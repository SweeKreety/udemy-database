package com.udemyproject.databasedemo.jdbc.entity;

import javax.persistence.*;

@Entity
@NamedQuery(name="find_all_persons", query="select p from Person p")
public class Person {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String location;

    public Person(){

    }

    public Person(int id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
    }
    public Person(String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
