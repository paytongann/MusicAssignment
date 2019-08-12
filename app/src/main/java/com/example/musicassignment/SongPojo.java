package com.example.musicassignment;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Song_Table")
class SongPojo {
    public String artistName;
    public String trackName;
    public String artworkUrl60;
    public String trackPrice;
    public String getArtistName(){return artistName;}
    public String getTrackName(){return trackName;}
    public String getArtworkUrl60(){return artworkUrl60;}
    public String getTrackPrice(){return trackPrice;}
}
