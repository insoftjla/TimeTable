package ru.sd.services;

import ru.sd.models.Subject;
import ru.sd.models.Timetable;

import java.util.List;
import java.util.Optional;

public interface TimetableService {

    List<Timetable> findAllByWeekDay(String weekDay);

    List<Timetable> findAll();

    public List<Subject> findAllSubjects();

    void addLesson(Timetable lesson);

    void delete(Timetable timetable);
}
