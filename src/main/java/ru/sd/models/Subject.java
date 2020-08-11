package ru.sd.models;

import javax.persistence.*;

@Entity
public class Subject {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    public Subject() {
    }

    public Subject(String name){
        this.name = name;
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

    public String getNameAndSubstring(int endIndex) {
        return name.length() > endIndex ? name.substring(0, endIndex) : name;
    }

    public String getNameAndSubstring() {
        return name.length() > 40 ? name.substring(0, 40) : name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
