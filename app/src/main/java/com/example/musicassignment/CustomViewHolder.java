    package com.example.musicassignment;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

public class CustomViewHolder extends RecyclerView.ViewHolder {

    ImageView ivAlbumPic;
    TextView tvSongName, tvAlbumName, tvSongPrice;

    public CustomViewHolder(@NonNull View itemView) {
        super(itemView);
        ivAlbumPic = itemView.findViewById(R.id.iv_album_pic);
        tvSongName = itemView.findViewById(R.id.tv_song_name);
        tvAlbumName = itemView.findViewById(R.id.tv_album_name);
        tvSongPrice = itemView.findViewById(R.id.tv_song_price);
    }

    public void bindViewHolder(final ResultItem item,
    final CustomListener listener) {
        tvSongName.setText(item.songPojo.collectionName);
        tvAlbumName.setText(item.songPojo.artistName);
        Picasso.get().load(item.songPojo.artworkUrl60)
                .into(ivAlbumPic);
        String trackPrice = item.songPojo.trackPrice.toString() + "USD";
        tvSongPrice.setText(trackPrice);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.itemClicked(item);
            }
        });
    }
}
