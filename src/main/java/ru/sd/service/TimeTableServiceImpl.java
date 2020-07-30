package ru.sd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.sd.dao.TimeTableDAO;
import ru.sd.models.TimeTable;

import java.util.List;

@Service
public class TimeTableServiceImpl implements TimeTableService {

    private TimeTableDAO timeTableDAO;

    @Autowired
    public void setTimeTableDAO(TimeTableDAO timeTableDAO) {
        this.timeTableDAO = timeTableDAO;
    }

    @Override
    @Transactional
    public List<TimeTable> allLesson() {
        return timeTableDAO.allLesson();
    }

    @Override
    @Transactional
    public void updateLesson(TimeTable timeTable) {
        timeTableDAO.updateLesson(timeTable);
    }

    @Override
    @Transactional
    public TimeTable getLessonById(int id) {
        return timeTableDAO.getLessonById(id);
    }
}
