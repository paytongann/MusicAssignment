package com.example.musicassignment;

import android.content.Context;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.converter.gson.GsonConverterFactory;

public class Retrofit {

    Context context;
    final String CONST_RESULTS = "50";
    final String CONST_BASEURL = "https://itunes.apple.com/";
    public static ResultsPojo musicResult;

    public Retrofit(Context context) {
        this.context = context;
    }

    public void initRetrofit(String genre){
        retrofit2.Retrofit retrofit = new retrofit2.Retrofit.Builder()
                .baseUrl(CONST_BASEURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiInterface apiInterface = retrofit.create(ApiInterface.class);

        apiInterface.getCategory(genre, "music", "song",CONST_RESULTS)
                .enqueue(new Callback<ResultsPojo>() {
            @Override
            public void onResponse(Call<ResultsPojo> call, Response<ResultsPojo> response) {
                if (response.isSuccessful() && response.body() != null) {
                    musicResult = response.body();
                    MainActivity mainActivity = (MainActivity)context;
                    mainActivity.getResults();
                }

            }

            @Override
            public void onFailure(Call<ResultsPojo> call, Throwable t) {
                musicResult = new ResultsPojo();
            }
        });
    }
}
