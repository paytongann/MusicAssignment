package com.example.musicassignment;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CustomAdapter extends RecyclerView.Adapter<CustomViewHolder> {

    private ResultsPojo dataSet;
    private CustomListener listener;

    public void setDataSet(ResultsPojo dataSet) {
        this.dataSet = dataSet;
        notifyDataSetChanged();
    }

    public void setListener(CustomListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CustomViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        holder.bindViewHolder(dataSet.resultItem.get(position), listener);
    }

    @Override
    public int getItemCount() {
        return dataSet != null ? dataSet.resultItem.size() : 0;
    }
}
