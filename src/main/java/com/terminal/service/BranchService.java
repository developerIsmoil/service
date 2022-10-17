package com.terminal.service;

import com.terminal.entity.Branch;
import com.terminal.model.filter.BranchFilterRequest;
import com.terminal.model.request.BranchRequest;
import org.springframework.data.domain.Page;

public interface BranchService {
    Page<Branch> findByName(BranchFilterRequest request);

    Branch save(BranchRequest request);

    public void delete(Long id);
}
