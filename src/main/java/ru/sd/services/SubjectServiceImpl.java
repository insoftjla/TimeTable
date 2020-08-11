package ru.sd.services;

import org.springframework.stereotype.Service;
import ru.sd.models.Subject;
import ru.sd.repositories.SubjectRepository;

import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {

    private final SubjectRepository subjectRepository;

    public SubjectServiceImpl(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }


    @Override
    public List<Subject> findAll() {
        return subjectRepository.findAll();
    }

    @Override
    public void add(Subject subject) {
        subjectRepository.save(subject);
    }

    @Override
    public void deleteById(Integer id) {
        subjectRepository.deleteById(id);
    }
}
