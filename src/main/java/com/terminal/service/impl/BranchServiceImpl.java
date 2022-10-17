package com.terminal.service.impl;

import com.terminal.entity.Branch;
import com.terminal.model.filter.BranchFilterRequest;
import com.terminal.model.request.BranchRequest;
import com.terminal.repository.BranchRepasitory;
import com.terminal.repository.RegionRepository;
import com.terminal.service.BranchService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BranchServiceImpl implements BranchService {
    @Autowired
    private BranchRepasitory branchRepasitory;
    @Autowired
    private RegionRepository regionRepository;

    @Override
    public Page<Branch> findByName(BranchFilterRequest request) {
        return branchRepasitory.findByName(request.getName(), PageRequest.of(request.getPage(), request.getLimit()));
    }

    @Override
    public Branch save(BranchRequest request) {
        Branch branch = request.getId() == null ? null :
                branchRepasitory.findById(request.getId()).
                        orElse(new Branch(request.getId()));
        branch.setName(request.getName() == null ? "" :
                request.getName());
        branch.setRegion(request.getRegionId() == null ? null :
                regionRepository.findById(request.getRegionId()).orElse(null));
        return branchRepasitory.save(branch);
    }

    @Override
    public void delete(Long id) {
        if (id != null)
            branchRepasitory.deleteById(id);
    }
}
