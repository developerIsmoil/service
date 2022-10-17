package com.terminal.model.filter;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrganizationFilterRequest extends FilterRequest {
    public String name;
}
