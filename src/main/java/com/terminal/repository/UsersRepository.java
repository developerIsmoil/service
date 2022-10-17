package com.terminal.repository;

import com.terminal.entity.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users, Long> {
    Page<Users> findByName(String name, Pageable pageable);

    boolean existsByEmail(String email);

    Optional<Object> findByEmail(String email);

    Users findByUsername(String username);
}
