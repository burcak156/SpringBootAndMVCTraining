package com.works.restfull.services;

import com.works.restfull.entities.JoinNoteCat;
import com.works.restfull.entities.Note;
import com.works.restfull.repositories.JoinNoteCatRepository;
import com.works.restfull.repositories.NoteRepository;
import com.works.restfull.utils.REnum;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;

@Service
//@RequiredArgsConstructor
public class NoteService {
    final NoteRepository noteRepo;
    final JoinNoteCatRepository jRepo;




    public NoteService(NoteRepository noteRepo, JoinNoteCatRepository jRepo) {
        this.noteRepo = noteRepo;
        this.jRepo = jRepo;
    }


    public ResponseEntity save(Note note) {
        Map<REnum, Object> hm = new LinkedHashMap<>();
        noteRepo.save(note);
        hm.put(REnum.status, true);
        hm.put(REnum.result, note);
        return new ResponseEntity(hm, HttpStatus.OK);
    }
/*
    public ResponseEntity listAll() {
        Map<REnum, Object> hm = new LinkedHashMap<>();
        hm.put(REnum.status, true);
        hm.put(REnum.result, noteRepo.findAll());
        return new ResponseEntity(hm, HttpStatus.OK);
    }
*/
    public ResponseEntity listAll() {
        Map<REnum, Object> hm = new LinkedHashMap<>();
        hm.put(REnum.status, true);
        hm.put(REnum.result, jRepo.joinList());
        return new ResponseEntity(hm, HttpStatus.OK);
    }

    public ResponseEntity listCat(int cid) {
        Map<REnum, Object> hm = new LinkedHashMap<>();
        hm.put(REnum.status, true);
        hm.put(REnum.result, jRepo.joinListCat(cid));
        return new ResponseEntity(hm, HttpStatus.OK);
    }
}
