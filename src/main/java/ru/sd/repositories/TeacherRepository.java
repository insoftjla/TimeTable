package ru.sd.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sd.models.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
}
