    package com.example.musicassignment;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

public class CustomViewHolder extends RecyclerView.ViewHolder {

    ImageView ivAlbumPic;
    TextView tvSongName, tvArtistName, tvSongPrice;

    public CustomViewHolder(@NonNull View itemView) {
        super(itemView);
        ivAlbumPic = itemView.findViewById(R.id.iv_album_pic);
        tvSongName = itemView.findViewById(R.id.tv_song_name);
        tvArtistName = itemView.findViewById(R.id.tv_artist_name);
        tvSongPrice = itemView.findViewById(R.id.tv_song_price);
    }

    public void setSongTitle(String titleString) {
        tvSongPrice.setText(titleString);
    }

    public void setSongPrice(String priceString) {
        tvSongPrice.setText(priceString);
    }

    public void setArtistName(String artistNameString) {
        tvArtistName.setText(artistNameString);
    }
    public void setSongPicture(String urlString){
        Picasso.get().load(urlString).placeholder(
                R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)
                .into(ivAlbumPic);
    }
}