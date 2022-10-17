package com.terminal.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class FilterRequest implements Serializable {
    private Integer page;
    private Integer limit;
}
