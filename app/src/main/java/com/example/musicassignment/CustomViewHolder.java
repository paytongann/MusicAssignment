package com.example.musicassignment;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;

public class CustomViewHolder extends RecyclerView.ViewHolder {
    public ImageView songPicture;
    public TextView songName,bandName,price;

    public CustomViewHolder(@NonNull View itemView) {
        super(itemView);
        songPicture = itemView.findViewById(R.id.iv_album_pic);
        songName = itemView.findViewById(R.id.tv_song_name);
        bandName = itemView.findViewById(R.id.tv_artist_name);
        price = itemView.findViewById(R.id.tv_song_price);
    }

    void setTitle(String title) {
        songName.setText(title);
    }
    void setPrice(String priceTag){price.setText("$"+priceTag+" USD");
    }
    void setBandName(String band){
        bandName.setText(band);
    }
    void setSongPicture(String url) {
        Picasso.get()
                .load(url)
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)
                .into(songPicture);

    }
}
