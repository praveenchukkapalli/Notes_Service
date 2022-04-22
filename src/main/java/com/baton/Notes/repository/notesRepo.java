package com.baton.Notes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.baton.Notes.model.notes;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface notesRepo extends JpaRepository<notes, Integer> {
    @Modifying
    @Query("update notes n SET n.is_active = false WHERE n.id = ?1")
    public void updateIsActiveStatus(int id);

    @Query("SELECT n from notes n where n.is_active=true")
    public List<notes> findallbyid();
}