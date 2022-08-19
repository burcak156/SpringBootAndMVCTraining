package com.works.restfull.repositories;

import com.works.restfull.entities.JoinNoteCat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JoinNoteCatRepository extends JpaRepository<JoinNoteCat, Integer> {

    @Query(value ="select rownum as jid, NID, DETAIL, TITLE, C.CID, C.NAME from NOTE inner join NOTE_CATEGORIES NC on NOTE.NID = NC.NOTES_NID inner join CATEGORY C on C.CID = NC.CATEGORIES_CID", nativeQuery = true)
    List<JoinNoteCat> joinList();

    @Query(value ="select rownum as jid, NID, DETAIL, TITLE, C.CID, C.NAME from NOTE inner join NOTE_CATEGORIES NC on NOTE.NID = NC.NOTES_NID inner join CATEGORY C on C.CID = NC.CATEGORIES_CID where c.cid = ?1", nativeQuery = true)
    List<JoinNoteCat> joinListCat(int cid);
}