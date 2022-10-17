package com.terminal.repository;

import com.terminal.entity.ApplicationMachine;
import com.terminal.entity.enums.Status;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.QueryHints;

import javax.persistence.QueryHint;

public interface AppMachineRepository extends JpaRepository<ApplicationMachine, Long> {
    @QueryHints(@QueryHint(name = org.hibernate.annotations.QueryHints.CACHEABLE, value = "true"))
    Page<ApplicationMachine> findByMachine_SerialNumberStartingWith(String name, Pageable pageable);

    @QueryHints(@QueryHint(name = org.hibernate.annotations.QueryHints.CACHEABLE, value = "true"))
    Page<ApplicationMachine> findByStatusAndMachine_SerialNumberStartsWith(
            Status status, String srNumber, Pageable pageable);
}
