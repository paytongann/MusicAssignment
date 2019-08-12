package com.example.musicassignment;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;

@Dao
public interface DatabaseInterface {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertSong(SongPojo... song);
}