package com.example.musicassignment;

import android.os.Parcel;
import android.os.Parcelable;

public class ResultItem implements Parcelable {

    SongPojo songPojo;

    protected ResultItem(Parcel in) {
    }

    public static final Creator<ResultItem> CREATOR = new Creator<ResultItem>() {
        @Override
        public ResultItem createFromParcel(Parcel in) {
            return new ResultItem(in);
        }

        @Override
        public ResultItem[] newArray(int size) {
            return new ResultItem[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
    }
}
