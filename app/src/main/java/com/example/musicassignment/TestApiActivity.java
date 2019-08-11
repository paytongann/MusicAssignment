package com.example.musicassignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TestApiActivity extends AppCompatActivity implements CustomListener{

    CustomAdapter adapter;
    RecyclerView recyclerView;
    Button rock,classic,pop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_api);
        rock = findViewById(R.id.btn_rock);
        classic = findViewById(R.id.btn_classic);
        pop = findViewById(R.id.btn_pop);
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(TestApiActivity.this));

        rock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setCategory("rock");
            }
        });

        classic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setCategory("classick");
            }
        });
        pop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setCategory("pop");
            }
        });
    }

    public void setCategory(String category) {
        getApiInterface().getCategory(category, "music", "song", "50").enqueue(new Callback<ResultsPojo>() {
            @Override
            public void onResponse(Call<ResultsPojo> call, Response<ResultsPojo> response) {
                if (response.isSuccessful()) {
                    adapter = new CustomAdapter();
                    adapter.setDataSet(response.body());
                    adapter.setListener(TestApiActivity.this);
                    recyclerView.setAdapter(adapter);
                } else
                    Toast.makeText(TestApiActivity.this, "bad code",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<ResultsPojo> call, Throwable t) {
                Toast.makeText(TestApiActivity.this, "Failed",Toast.LENGTH_SHORT).show();
            }
        });
    }

    public ApiInterface getApiInterface() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://itunes.apple.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(ApiInterface.class);
    }

    @Override
    public void itemClicked(ResultItem item) {

    }
}
