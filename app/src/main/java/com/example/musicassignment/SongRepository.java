package com.example.musicassignment;

import android.app.Application;
import android.os.AsyncTask;

public class SongRepository {
    private DatabaseInterface databaseInterface;

    public SongRepository(Application application) {
        SongDatabase db = SongDatabase.getInstance(application);
        databaseInterface = db.songDao();
    }

    public void insert(SongPojo songPojo) {
        new insertAsyncTask(databaseInterface).execute(songPojo);
    }

    private class insertAsyncTask extends AsyncTask<SongPojo, Void, Void> {
        private DatabaseInterface databaseInterface;

        public insertAsyncTask(DatabaseInterface databaseInterface) {
            this.databaseInterface = databaseInterface;
        }

        protected Void doInBackground(SongPojo... SongEntities) {
            databaseInterface.insertSong(SongEntities[0]);
            return null;
        }
    }
}