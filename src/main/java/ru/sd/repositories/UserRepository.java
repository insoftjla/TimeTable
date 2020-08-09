package ru.sd.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sd.models.UserLogin;

public interface UserRepository extends JpaRepository<UserLogin, Long> {
    UserLogin findByUsername(String username);
}
