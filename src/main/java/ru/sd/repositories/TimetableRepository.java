package ru.sd.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sd.models.Pgroup;
import ru.sd.models.Timetable;

import java.util.List;


public interface TimetableRepository extends JpaRepository<Timetable, Integer> {

    List<Timetable> findByWeekDayAndPgroupIdOrderByNumberLesson(int weekDay, int groupId);


}
