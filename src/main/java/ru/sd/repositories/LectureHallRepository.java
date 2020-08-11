package ru.sd.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sd.models.LectureHall;

public interface LectureHallRepository extends JpaRepository<LectureHall, Integer> {
}
