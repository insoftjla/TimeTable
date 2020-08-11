package ru.sd.services;

import ru.sd.models.Subject;
import ru.sd.models.Teacher;

import java.util.List;

public interface TeacherService {
    List<Teacher> findAll();
    void add(Teacher teacher);
    void deleteById(Integer id);
}
