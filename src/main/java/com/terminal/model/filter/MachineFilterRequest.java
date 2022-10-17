package com.terminal.model.filter;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MachineFilterRequest extends FilterRequest {
    private String serialNumber ;
}
