package ru.sd.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.sd.models.*;
import ru.sd.repositories.*;

import java.util.List;

@Service
public class TimetableServiceImpl implements TimetableService {

    @Autowired
    private TimetableRepository timetableRepository;
    @Autowired
    private LectureHallRepository lectureHallRepository;
    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private PgroupRepository pgroupRepository;


    @Override
    public List<Timetable> findByWeekDay(int weekDay, int groupId) {
        return timetableRepository.findByWeekDayAndPgroupIdOrderByNumberLesson(weekDay, groupId);
    }

    @Override
    public List<Timetable> findAll() {
        return timetableRepository.findAll();
    }

    @Override
    public List<LectureHall> findAllLectureHalls() {
        return lectureHallRepository.findAll();
    }

    @Override
    public List<Teacher> findAllTeacher() {
        return teacherRepository.findAll();
    }

    @Override
    public List<Pgroup> findAllPgroup() {
        return pgroupRepository.findAll();
    }

    @Override
    public Pgroup findPgroupById(int id) {
        return pgroupRepository.findById(id);
    }

    @Override
    public void addLesson(Timetable lesson) {
        timetableRepository.save(lesson);
    }

    @Override
    public void deleteLessonById(Integer lessonId) {
        timetableRepository.deleteById(lessonId);
    }
}
