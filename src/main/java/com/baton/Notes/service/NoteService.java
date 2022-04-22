package com.baton.Notes.service;
import com.baton.Notes.repository.notesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import com.baton.Notes.model.notes;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class NoteService {

    @Autowired
    notesRepo notesrepo;

    public notes addNotes(notes note){
        notesrepo.save(note);
        return note;
    }


    public List<notes> getAllNotes(){
        List<notes> Retrieved_Notes = notesrepo.findallbyid();
        return Retrieved_Notes;
    }

    public String deleteNote(Integer id){
        notesrepo.updateIsActiveStatus(id);
        return "Note Deleted Successfully !";

    }

}
