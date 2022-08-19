package com.works.restfull.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer rid;

    private String role;

    @ManyToMany(mappedBy = "roles")
    List<Admin> admins;
}
