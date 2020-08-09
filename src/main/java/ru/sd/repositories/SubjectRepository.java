package ru.sd.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sd.models.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Integer> {
}
