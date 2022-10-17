package com.terminal.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "machine")
public class Machine implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String serialNumber;


    @ManyToOne
    private Organization organization;

    @ManyToOne
    private Category category;

    @ManyToOne
    private Models models;

    public Machine(Long id) {
        this.id = id;
    }
}
