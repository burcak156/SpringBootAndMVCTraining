package com.works.restfull.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pid;

    @NotEmpty(message = "Title bos olamaz")
    @NotNull(message = "Title null olamaz")
    @Column(length = 100)
    private String title;

    @NotNull
    @Column(length = 500)
    private String detail;

    @NotNull
    @Min(1)
    @Max(10000)
    private Integer price;

    @Email(regexp = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
            + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$")
    @Column(length = 150)
    private String email;
}
