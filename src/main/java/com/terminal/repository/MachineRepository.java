package com.terminal.repository;

import com.terminal.entity.Machine;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MachineRepository extends JpaRepository<Machine, Long> {
    Page<Machine> findBySerialNumberStartingWith(String name, Pageable pageable);

    Page<Machine> findAllByCategory_id(Long categoryId, Pageable pageable);



 }
