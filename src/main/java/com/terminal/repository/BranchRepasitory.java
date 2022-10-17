package com.terminal.repository;

import com.terminal.entity.Branch;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BranchRepasitory extends JpaRepository<Branch, Long> {
    Page<Branch> findByName(String name, Pageable pageable);
}
