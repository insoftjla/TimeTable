package ru.sd.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sd.models.User;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
