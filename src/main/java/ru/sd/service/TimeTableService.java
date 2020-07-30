package ru.sd.service;

import ru.sd.models.TimeTable;

import java.util.List;

public interface TimeTableService {
    List<TimeTable> allLesson();
    void updateLesson(TimeTable timeTable);
    TimeTable getLessonById(int id);
}
