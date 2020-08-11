package ru.sd.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sd.models.Pgroup;

public interface PgroupRepository extends JpaRepository<Pgroup, Integer> {
    Pgroup findById(int id);
}
