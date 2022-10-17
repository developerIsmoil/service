package com.terminal.service;

import com.terminal.entity.Region;
import com.terminal.model.filter.RegionFilterRequest;
import org.springframework.data.domain.Page;

public interface RegionService {
    Page<Region> findByName(RegionFilterRequest request);
}
