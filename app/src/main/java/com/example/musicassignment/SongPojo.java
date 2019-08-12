package com.example.musicassignment;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Song_Table")
public class SongPojo {
    @ColumnInfo(name = "ArtWork")
    public String artworkUrl60;
    @ColumnInfo(name = "Track")
    public String collectionName;
    @ColumnInfo(name = "ArtistName")
    public String artistName;
    @ColumnInfo(name = "TrackPrice")
    public String trackPrice;

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    public int id;
    public String previewUrl;

    @NonNull
    public String getCollectionName() {
        return collectionName;
    }

    public String getArtistName() { return artistName; }

    public String getArtworkUrl60() {
        return artworkUrl60;
    }

    public String getTrackPrice() { return trackPrice; }
}