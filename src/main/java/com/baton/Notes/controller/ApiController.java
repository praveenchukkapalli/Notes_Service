package com.baton.Notes.controller;

import com.baton.Notes.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.baton.Notes.model.notes;
import java.util.List;

@RestController
public class ApiController {
    @Autowired
    NoteService noteservice;

    @RequestMapping(method = RequestMethod.POST, value = "note/add")
    private notes addNote(@RequestBody notes note) {
        note.setIs_active(true);
        noteservice.addNotes(note);
        return note;
    }

    @RequestMapping(method = RequestMethod.GET,value="/note/list")
    private List<notes> getAllNotes()
    {
        return noteservice.getAllNotes();
    }


    @RequestMapping(method = RequestMethod.DELETE,value="/note/")
    private String deleteNote(@RequestParam("id") int id)
    {
        return noteservice.deleteNote(id);
    }


}
