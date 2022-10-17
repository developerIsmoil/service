package com.terminal.service;

import com.terminal.entity.Application;
import com.terminal.model.filter.ApplicationFilterRequest;
import com.terminal.model.request.ApplicationRequest;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ApplicationService extends AbstractService{
    Page<Application> findByName(ApplicationFilterRequest request);

    Application save(ApplicationRequest request);

    void delete(Long id);
}
