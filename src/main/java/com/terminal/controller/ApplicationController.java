package com.terminal.controller;

import com.terminal.entity.Application;
import com.terminal.model.filter.ApplicationFilterRequest;
import com.terminal.model.request.ApplicationRequest;
import com.terminal.service.ApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/application")
public class ApplicationController {
    @Autowired
    private ApplicationService applicationService;

    //    @Cacheable(value = "application123", key = "{ #request.serialNumber }")
    @GetMapping("/list")
    public ResponseEntity<Page<Application>> list(
            ApplicationFilterRequest request) {
//        cacheManager.getCache("application").evict(request.getSerialNumber());
        return ResponseEntity.ok(applicationService.findByName(request));
    }
//    @Autowired
//    private CacheManager cacheManager;

    @Transactional
    @PostMapping("/save")
    public ResponseEntity<Application> save(@RequestBody ApplicationRequest request) {
        return ResponseEntity.ok(applicationService.save(request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        applicationService.delete(id);
        return ResponseEntity.ok().build();
    }
}
