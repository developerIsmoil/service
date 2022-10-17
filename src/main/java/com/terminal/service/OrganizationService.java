package com.terminal.service;

import com.terminal.entity.Organization;
import com.terminal.exceptions.RequiredException;
import com.terminal.model.filter.OrganizationFilterRequest;
import com.terminal.model.request.OrganizationRequest;
import org.springframework.data.domain.Page;

public interface OrganizationService {

    Page<Organization> findByName(OrganizationFilterRequest request );

    Organization save(OrganizationRequest organizationRequest) throws RequiredException;

    void delete(Long id);
}
