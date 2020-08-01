package ru.sd.repos;

import org.springframework.data.repository.CrudRepository;
import ru.sd.models.LessonType;

public interface LessonTypesRepo extends CrudRepository<LessonType, Integer> {
}
