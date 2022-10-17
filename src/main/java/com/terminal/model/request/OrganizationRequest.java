package com.terminal.model.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class OrganizationRequest implements Serializable {
    private Long id;
    private String name;
    private Long branchId;
    private Long regionId;
}
