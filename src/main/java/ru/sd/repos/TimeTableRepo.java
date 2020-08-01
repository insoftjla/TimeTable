package ru.sd.repos;

import org.springframework.data.repository.CrudRepository;
import ru.sd.models.TimeTable;

public interface TimeTableRepo extends CrudRepository<TimeTable, Integer> {
}
