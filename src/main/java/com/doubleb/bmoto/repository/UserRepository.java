package com.doubleb.bmoto.repository;

import com.doubleb.bmoto.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

    @Query("select u from User u where lower(u.username) = ?1")
    User getUserByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
}
