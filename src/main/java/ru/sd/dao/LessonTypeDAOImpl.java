package ru.sd.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.sd.models.LessonType;

import java.util.List;

@Component
public class LessonTypeDAOImpl implements LessonTypeDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<LessonType> allTypes() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from LessonType").list();
    }

    @Override
    public void addType(LessonType lessonType) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(lessonType);
    }

    @Override
    public void updateType(LessonType lessonType) {
        Session session = sessionFactory.getCurrentSession();
        session.update(lessonType);
    }

    @Override
    public LessonType getTypeById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(LessonType.class, id);
    }
}
