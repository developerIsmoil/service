package com.terminal.service.impl;

import com.terminal.entity.Organization;
import com.terminal.exceptions.RequiredException;
import com.terminal.model.filter.OrganizationFilterRequest;
import com.terminal.model.request.OrganizationRequest;
import com.terminal.repository.BranchRepasitory;
import com.terminal.repository.OrganizationRepository;
import com.terminal.repository.RegionRepository;
import com.terminal.service.OrganizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {

    private final OrganizationRepository organizationRepository;
    private final BranchRepasitory branchRepasitory;
    private final RegionRepository regionRepository;

    @Override
    public Page<Organization> findByName(OrganizationFilterRequest request) {
        return organizationRepository.findByNameStartingWith(request.getName(),
                PageRequest.of(request.getPage(), request.getLimit()));
    }

    @Override
    public Organization save(OrganizationRequest organizationRequest) {
        if (organizationRequest.getId() == null) {
            throw new RequiredException("id is null");
        } else if (organizationRequest.getBranchId() == null) {
            throw new RequiredException("branchId is null");
        } else if (organizationRequest.getName() == null) {
            throw new RequiredException("name is null");
        } else if (organizationRequest.getRegionId() == null) {
            throw new RequiredException("regionId is null");
        }
        Organization organization = organizationRequest.getId() == null ? null :
                organizationRepository.findById(organizationRequest.getId())
                        .orElse(new Organization());
        organization.setBranch(branchRepasitory.findById(organizationRequest.getBranchId())
                .orElse(null));
        organization.setName(organizationRequest.getName());
        organization.setRegion(organizationRequest.getRegionId() == null ? null :
                regionRepository.findById(organizationRequest.getRegionId())
                        .orElse(null));

        return organization;
    }

    @Override
    public void delete(Long id) {
        if (id != null)
            organizationRepository.deleteById(id);
    }
}
