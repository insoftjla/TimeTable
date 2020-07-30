package ru.sd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sd.dao.LessonTypeDAO;
import ru.sd.models.LessonType;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class LessonTypeServiceImpl implements LessonTypeService {

    private LessonTypeDAO lessonTypeDAO;

    @Autowired
    public void setLessonTypeDAO(LessonTypeDAO lessonTypeDAO) {
        this.lessonTypeDAO = lessonTypeDAO;
    }

    @Override
    @Transactional
    public List<LessonType> allLessons() {
        return lessonTypeDAO.allTypes();
    }

    @Override
    @Transactional
    public void addLesson(LessonType lessonType) {
        lessonTypeDAO.addType(lessonType);
    }

    @Override
    @Transactional
    public void updateLesson(LessonType lessonType) {
        lessonTypeDAO.addType(lessonType);
    }

    @Override
    @Transactional
    public LessonType getLessonById(int id) {
        return lessonTypeDAO.getTypeById(id);
    }
}
