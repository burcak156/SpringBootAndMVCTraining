package com.works.restfull.restcontroller;

import com.works.restfull.entities.Note;
import com.works.restfull.services.NoteService;
import com.works.restfull.utils.REnum;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/note")
public class NoteRestController {

    final NoteService noteService;

    public NoteRestController(NoteService noteService) {
        this.noteService = noteService;
    }

    @PostMapping("/save")
    public ResponseEntity save(@RequestBody Note note) {
        return new ResponseEntity(noteService.save(note), HttpStatus.OK);
    }

    @GetMapping("/listAll")
    public ResponseEntity listAll() {
        return new ResponseEntity(noteService.listAll(),HttpStatus.OK);
    }

    @GetMapping("/list/{cid}")
    public ResponseEntity listCat(@PathVariable int cid) {
        return new ResponseEntity(noteService.listCat(cid),HttpStatus.OK);
    }
}
