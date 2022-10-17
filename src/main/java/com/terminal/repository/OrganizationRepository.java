package com.terminal.repository;

import com.terminal.entity.Organization;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizationRepository extends JpaRepository<Organization, Long> {
    Page<Organization> findByNameStartingWith(String name, Pageable pageable);

}
