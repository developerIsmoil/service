package com.terminal.controller;

import com.terminal.entity.Branch;
import com.terminal.model.filter.BranchFilterRequest;
import com.terminal.model.request.BranchRequest;
import com.terminal.service.BranchService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/branch")
public class BranchController {
    @Autowired
    private BranchService branchService;

    @GetMapping("/list")
    public ResponseEntity<Page<Branch>> list(BranchFilterRequest request) {
        return ResponseEntity.ok(branchService.findByName(request));
    }

    @PostMapping("/save")
    public void save(@RequestBody BranchRequest branchRequest) {
        branchService.save(branchRequest);
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        branchService.delete(id);
    }
}
