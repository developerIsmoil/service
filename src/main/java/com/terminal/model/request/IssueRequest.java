package com.terminal.model.request;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class IssueRequest implements Serializable {
    private Long id;
    private String name;


}
