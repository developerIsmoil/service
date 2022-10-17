package com.terminal.service.impl;

import com.terminal.entity.Application;
import com.terminal.model.filter.ApplicationFilterRequest;
import com.terminal.model.request.ApplicationRequest;
import com.terminal.repository.ApplicationRepository;
import com.terminal.repository.OrganizationRepository;
import com.terminal.service.ApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ApplicationServiceImpl implements ApplicationService {
    private final OrganizationRepository organizationRepository;
    @Autowired
    private ApplicationRepository applicationRepasitory;

    @Override
    public Page<Application> findByName(ApplicationFilterRequest request) {
        return applicationRepasitory.findBySerialNumberStartingWith(
                checkNull(request.getSerialNumber()), PageRequest.of(request.getPage(), request.getLimit()));
    }

    @Override
    public Application save(ApplicationRequest request) {

        Application application = request.getId() == null ? new Application()
                : applicationRepasitory.findById(request.getId())
                .orElse(new Application(request.getId()));

        application.setAppNumber(request.getAppNumber());
        application.setSerialNumber(request.getSerialNumber());
        application.setOrganization(request.getOrganizationId() == null ? null :
                organizationRepository.findById(request.getOrganizationId()).orElse(null));
        return applicationRepasitory.save(application);
    }

    @Override
    public void delete(Long id) {
        if (id != null)
        applicationRepasitory.deleteById(id);
    }
}

