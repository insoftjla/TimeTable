package ru.sd.services;

import org.springframework.stereotype.Service;
import ru.sd.models.Teacher;
import ru.sd.repositories.TeacherRepository;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;

    public TeacherServiceImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public List<Teacher> findAll() {
        return teacherRepository.findAll();
    }

    @Override
    public void add(Teacher teacher) {
        teacherRepository.save(teacher);
    }

    @Override
    public void deleteById(Integer id) {
        teacherRepository.deleteById(id);
    }
}
