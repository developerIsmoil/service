package com.terminal.controller;

import com.terminal.entity.Region;
import com.terminal.model.filter.RegionFilterRequest;
import com.terminal.service.RegionService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/region")
public class RegionController {
    private final RegionService regionService;

    public RegionController(RegionService regionService) {
        this.regionService = regionService;
    }

    @GetMapping("/list")
    public ResponseEntity<Page<Region>> list(RegionFilterRequest request) {
        return ResponseEntity.ok(regionService.findByName(request));
    }
}
