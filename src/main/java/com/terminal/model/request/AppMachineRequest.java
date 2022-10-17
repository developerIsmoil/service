package com.terminal.model.request;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class AppMachineRequest implements Serializable {
    private Long id;
    private Long machineId;
    private Long applicationId;
    private Long categoryId;

}
