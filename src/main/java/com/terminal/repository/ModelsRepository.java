package com.terminal.repository;

import com.terminal.entity.Models;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelsRepository extends JpaRepository<Models,Long> {
    Page<Models> findByNameStartingWith(String name, Pageable pageable);

}
