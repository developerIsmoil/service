package com.terminal.model.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Builder
public class UserRequest implements Serializable {
    private Long id;
    private String name;
    private String userName;
    private Long branchId;
    private Long organizationId;

}
