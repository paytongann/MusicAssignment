package com.example.musicassignment;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomViewHolder> {
    private List<SongPojo> dataset;

    public void setDataset(List<SongPojo> data){
        this.dataset = data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new CustomViewHolder(
                LayoutInflater
                        .from(viewGroup.getContext()).inflate(
                        R.layout.item_layout,
                        viewGroup,
                        false
                ));
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder customViewHolder, int i) {
        customViewHolder.setTitle(dataset.get(i).getCollectionName());
        customViewHolder.setBandName(dataset.get(i).getArtistName());
        customViewHolder.setPrice(dataset.get(i).getTrackPrice());
        customViewHolder.setSongPicture(dataset.get(i).getArtworkUrl60());
    }

    @Override
    public int getItemCount() {
        return dataset != null ? dataset.size() : 0;
    }
}
