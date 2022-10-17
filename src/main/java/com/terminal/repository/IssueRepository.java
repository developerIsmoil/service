package com.terminal.repository;

import com.terminal.entity.Issue;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueRepository extends JpaRepository<Issue, Long> {
    Page<Issue> findByNameStartsWith(String name, Pageable pageable);
}
