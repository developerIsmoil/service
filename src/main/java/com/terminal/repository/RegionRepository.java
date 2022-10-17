package com.terminal.repository;

import com.terminal.entity.Region;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegionRepository extends JpaRepository<Region, Long> {
    Page<Region> findByNameStartsWith(String name, Pageable pageable);
}
