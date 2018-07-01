package com.example.android.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.android.model.Journal;

import java.util.List;

@Dao
public interface JournalDao {
    @Query("SELECT * FROM journal")
    List<Journal> getAll();

    @Query("SELECT * FROM journal WHERE email LIKE :email ")
    List<Journal> loadAllByEmail(String email);

    @Query("SELECT * FROM journal WHERE id = :id")
    Journal findById(int id);

    @Insert
    void insertAll(Journal... journals);

    @Delete
    void delete(Journal journal);
}