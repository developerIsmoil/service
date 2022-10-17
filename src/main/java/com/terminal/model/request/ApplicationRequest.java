package com.terminal.model.request;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Getter
@Setter
@SuperBuilder
public class ApplicationRequest implements Serializable {
      private Long id;
      private Long appNumber;
      private String serialNumber;
      private Long organizationId;

}
