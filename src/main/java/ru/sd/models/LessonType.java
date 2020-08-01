package ru.sd.models;

import javax.persistence.*;

@Entity
public class LessonType {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    private String title;

    public LessonType() {
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "LessonType{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
