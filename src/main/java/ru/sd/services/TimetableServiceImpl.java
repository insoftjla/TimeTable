package ru.sd.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sd.models.Subject;
import ru.sd.models.Timetable;
import ru.sd.repositories.SubjectRepository;
import ru.sd.repositories.TimetableRepository;

import java.util.List;

@Service
public class TimetableServiceImpl implements TimetableService {

    @Autowired
    private TimetableRepository timetableRepository;

    @Autowired
    private SubjectRepository subjectRepository;


    @Override
    public List<Timetable> findAllByWeekDay(String weekDay) {
        return timetableRepository.findAllByWeekDay(weekDay);
    }

    @Override
    public List<Timetable> findAll() {
        return timetableRepository.findAll();
    }

    @Override
    public List<Subject> findAllSubjects() {
        return subjectRepository.findAll();
    }

    @Override
    public void addLesson(Timetable lesson) {
        timetableRepository.save(lesson);
    }

    @Override
    public void delete(Timetable timetable) {
        timetableRepository.delete(timetable);
    }
}
