package ru.sd.services;

import org.springframework.data.domain.Sort;
import ru.sd.models.*;

import java.util.List;

public interface TimetableService {

    List<Timetable> findByWeekDay(int weekDay, int groupId);

    List<Timetable> findAll();

    List<LectureHall> findAllLectureHalls();

    List<Teacher> findAllTeacher();

    List<Pgroup> findAllPgroup();

    Pgroup findPgroupById(int id);

    void addLesson(Timetable lesson);

    void deleteLessonById(Integer lessonId);
}
