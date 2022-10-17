package com.terminal.repository;

import com.terminal.entity.Application;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepository extends JpaRepository<Application, Long> {
    Page<Application> findBySerialNumberStartingWith(String serialNumber, Pageable pageable);

    Page<Application> findBySerialNumber(String serialNumber, Pageable pageable);

    Page<Application> findByOrganization(String serialNumber, Pageable pageable);

}
