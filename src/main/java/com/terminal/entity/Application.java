package com.terminal.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "application")
public class Application  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long appNumber;
    private String serialNumber;
    private Date date;

    @ManyToOne
    private Organization organization;

    @ManyToOne
    private Users user;

    @ManyToOne
    private Issue issue;


    public Application(Long id) {
        this.id = id;
    }
}
