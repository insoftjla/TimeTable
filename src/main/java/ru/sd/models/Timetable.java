package ru.sd.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Timetable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int weekDay;
    private int numberLesson;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pgroup_id")
    private Pgroup pgroup;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subject_id")
    private Subject subject;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lecture_hall_id")
    private LectureHall lectureHall;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    public Timetable() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(int weekDay) {
        this.weekDay = weekDay;
    }

    public int getNumberLesson() {
        return numberLesson;
    }

    public void setNumberLesson(int numberLesson) {
        this.numberLesson = numberLesson;
    }

    public Pgroup getPgroup() {
        return pgroup;
    }

    public void setPgroup(Pgroup pgroup) {
        this.pgroup = pgroup;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public LectureHall getLectureHall() {
        return lectureHall;
    }

    public void setLectureHall(LectureHall lectureHall) {
        this.lectureHall = lectureHall;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "Timetable{" +
                "id=" + id +
                ", week_day='" + weekDay + '\'' +
                ", number_lesson=" + numberLesson +
                ", pgroup=" + pgroup +
                ", subject=" + subject +
                ", lectureHall=" + lectureHall +
                ", teacher=" + teacher +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Timetable timetable = (Timetable) o;
        return id == timetable.id &&
                numberLesson == timetable.numberLesson &&
                Objects.equals(weekDay, timetable.weekDay) &&
                Objects.equals(pgroup, timetable.pgroup) &&
                Objects.equals(subject, timetable.subject) &&
                Objects.equals(lectureHall, timetable.lectureHall) &&
                Objects.equals(teacher, timetable.teacher);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, weekDay, numberLesson, pgroup, subject, lectureHall, teacher);
    }
}
