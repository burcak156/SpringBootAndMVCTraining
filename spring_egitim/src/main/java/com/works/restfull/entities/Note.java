package com.works.restfull.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Note extends Base{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer nid;
    private String title;
    private String detail;

    @ManyToMany
    //@JoinColumn(name = "category_ID")
    private List<Category> categories;
}
