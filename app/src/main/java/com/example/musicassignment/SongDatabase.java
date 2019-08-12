package com.example.musicassignment;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;

@Database(entities = {SongPojo.class}, version = 1)
public abstract class SongDatabase extends androidx.room.RoomDatabase {

    private static volatile SongDatabase INSTANCE;

    public abstract DatabaseInterface songDao();

    static SongDatabase getInstance(final Context context){
        if(INSTANCE == null){
            synchronized (SongDatabase.class){
                if(INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(
                            context.getApplicationContext(),
                            SongDatabase.class,
                            "song_db")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
