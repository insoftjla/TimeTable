package ru.sd.dao;

import ru.sd.models.TimeTable;

import java.util.List;

public interface TimeTableDAO {
    List<TimeTable> allLesson();
    void updateLesson(TimeTable timeTable);
    TimeTable getLessonById(int id);
}
