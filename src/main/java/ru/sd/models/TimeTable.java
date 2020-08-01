package ru.sd.models;

import javax.persistence.*;

@Entity
public class TimeTable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "type")
    private String type;

    @Column(name = "lecturehall")
    private String lecturehall;

    @Column(name = "teacher")
    private String teacher;

    public TimeTable() {
    }

    public TimeTable(String title, String type, String lecturehall, String teacher) {
        this.title = title;
        this.type = type;
        this.lecturehall = lecturehall;
        this.teacher = teacher;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLecturehall() {
        return lecturehall;
    }

    public void setLecturehall(String lecturehall) {
        this.lecturehall = lecturehall;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "TimeTable{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", type='" + type + '\'' +
                ", lecturehall='" + lecturehall + '\'' +
                ", teacher='" + teacher + '\'' +
                '}';
    }
}
