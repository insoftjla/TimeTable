package ru.sd.dao;

import ru.sd.models.LessonType;

import java.util.List;

public interface LessonTypeDAO {
    List<LessonType> allTypes();
    void addType(LessonType lessonType);
    void updateType(LessonType lessonType);
    LessonType getTypeById(int id);
}
