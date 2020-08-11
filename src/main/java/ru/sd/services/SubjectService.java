package ru.sd.services;

import ru.sd.models.Subject;

import java.util.List;

public interface SubjectService {
    List<Subject> findAll();
    void add(Subject subject);
    void deleteById(Integer id);
}
