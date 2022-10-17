package com.terminal.service.impl;

import com.terminal.entity.Region;
import com.terminal.model.filter.RegionFilterRequest;
import com.terminal.repository.RegionRepository;
import com.terminal.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class RegionServiceImpl implements RegionService {

    private final RegionRepository regionRepository;

    @Autowired
    public RegionServiceImpl(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }

    @Override
    public Page<Region> findByName(RegionFilterRequest request) {
        return regionRepository.findByNameStartsWith(request.getName(),
                PageRequest.of(request.getPage(), request.getLimit()));
    }
}
