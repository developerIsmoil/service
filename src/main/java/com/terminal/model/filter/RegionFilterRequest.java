package com.terminal.model.filter;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegionFilterRequest extends FilterRequest {
    private String name;
}
