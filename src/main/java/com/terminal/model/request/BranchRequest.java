package com.terminal.model.request;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class BranchRequest implements Serializable {
    private Long id;
    private String name;
    private Long regionId;

}
