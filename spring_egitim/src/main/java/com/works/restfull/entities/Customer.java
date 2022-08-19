package com.works.restfull.entities;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Customer {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @Column(unique = true)
    private String email;
    private String password;
}
