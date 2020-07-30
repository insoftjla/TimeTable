package ru.sd.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.sd.models.TimeTable;

import java.util.List;

@Component
public class TimeTableDAOImpl implements TimeTableDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<TimeTable> allLesson() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from TimeTable").list();
    }

    @Override
    public void updateLesson(TimeTable timeTable) {
        Session session = sessionFactory.getCurrentSession();
        session.update(timeTable);
    }

    @Override
    public TimeTable getLessonById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(TimeTable.class, id);
    }
}
