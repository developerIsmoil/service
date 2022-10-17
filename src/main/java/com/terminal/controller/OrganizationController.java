package com.terminal.controller;


import com.terminal.entity.Organization;
import com.terminal.model.filter.OrganizationFilterRequest;
import com.terminal.model.request.OrganizationRequest;
import com.terminal.service.OrganizationService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/organization")
public class OrganizationController {
    private final OrganizationService organizationService;

    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @GetMapping("/list")
    public ResponseEntity<Page<Organization>>  list(OrganizationFilterRequest request){
        return ResponseEntity.ok(organizationService.findByName(request));
    }

    @PostMapping("/save")
    public void save(@RequestBody OrganizationRequest request){
        organizationService.save(request);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam Long id){
        organizationService.delete(id);
    }
}
