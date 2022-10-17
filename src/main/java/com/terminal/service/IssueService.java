package com.terminal.service;

import com.terminal.entity.Issue;
import com.terminal.model.filter.IssueFilterRequest;
import com.terminal.model.request.IssueRequest;
import org.springframework.data.domain.Page;

public interface IssueService {
    Page<Issue> findByName(IssueFilterRequest request);

    Issue save(IssueRequest request);

    public void delete(Long id);
}
