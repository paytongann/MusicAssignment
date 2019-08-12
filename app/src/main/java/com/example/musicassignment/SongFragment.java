package com.example.musicassignment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class SongFragment extends Fragment {

    private RecyclerView recyclerView;
    public String genre;
    CustomAdapter adapter;

    public interface Communicator{
        void requestSongs(String genre, SongFragment fragment);
    }
    Communicator communicator;
    public SongFragment() {}

    public void setCommunicator(Communicator communicator) {
        this.communicator = communicator;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_layout,
                container, false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof Communicator)
            communicator = (Communicator) context;
        else
            throw new ClassCastException("");

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recycler_view);
        adapter = new CustomAdapter();

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
        requestSongs();
    }

    public void getResults() {
        ResultsPojo resultsPojo = Retrofit.musicResult;
        adapter.setDataset(resultsPojo.getResults());
    }

    public void requestSongs() {
        communicator.requestSongs(genre, this);
    }
}
