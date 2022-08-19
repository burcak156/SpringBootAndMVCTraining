package com.works.restfull.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class JoinNoteCat {

    @Id
    @JsonIgnore
    private Integer jid;
    private Integer nid;
    private String detail;
    private String title;
    private Integer cid;
    private String name;
    /*
    select NID, DETAIL, TITLE, C.CID, C.NAME from NOTE
    inner join NOTE_CATEGORIES NC on NOTE.NID = NC.NOTES_NID
    inner join CATEGORY C on C.CID = NC.CATEGORIES_CID

     */
}
