package com.torin.blog.repositories;

import com.torin.blog.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    @Query(value = "select id from users where email = ?1", nativeQuery = true)
    Optional<Long> getUserIdByEmail(String email);
}
