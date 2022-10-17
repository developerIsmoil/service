package com.terminal.model.filter;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class FilterRequest implements Serializable {
    private Integer page = 0;
    private Integer limit = 10;
}
