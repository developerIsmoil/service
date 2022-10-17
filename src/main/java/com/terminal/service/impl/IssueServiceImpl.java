package com.terminal.service.impl;

import com.terminal.entity.Issue;
import com.terminal.model.filter.IssueFilterRequest;
import com.terminal.model.request.IssueRequest;
import com.terminal.repository.IssueRepository;
import com.terminal.service.IssueService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class IssueServiceImpl implements IssueService {

    private final IssueRepository issueRepository;

    @Override
    public Page<Issue> findByName(IssueFilterRequest request) {
        return issueRepository.findByNameStartsWith(request.getName(),
                PageRequest.of(request.getPage(), request.getLimit()));
    }

    @Override
    public Issue save(IssueRequest request) {
        Issue issue = request.getId() == null ? null :
                issueRepository.findById(request.getId())
                        .orElse(new Issue());
        issue.setName(request.getName());
        issue.setParent(issue.getParent());
        return issueRepository.save(issue);
    }

    @Override
    public void delete(Long id) {
        if (id != null)
            issueRepository.deleteById(id);
    }
}
