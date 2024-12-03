package com.boot.novel.repository;

import com.boot.novel.models.User;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);
    Optional<User> findByUsername(String username);
}
