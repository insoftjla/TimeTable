package ru.sd.service;

import ru.sd.models.LessonType;

import java.util.List;

public interface LessonTypeService {

    List<LessonType> allLessons();
    void addLesson(LessonType lessonType);
    void updateLesson(LessonType lessonType);
    LessonType getLessonById(int id);
}
