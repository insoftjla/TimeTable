package ru.sd.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sd.models.Timetable;

import java.util.List;


public interface TimetableRepository extends JpaRepository<Timetable, Integer> {

    List<Timetable> findAllByWeekDay(String weekDay);
}
