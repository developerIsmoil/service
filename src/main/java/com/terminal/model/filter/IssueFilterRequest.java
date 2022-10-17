package com.terminal.model.filter;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IssueFilterRequest extends FilterRequest {
    private String name;
}
