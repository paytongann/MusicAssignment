package com.example.musicassignment;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("search")
    Call<ResultsPojo> getMusic(@Query("term") String genre,
                               @Query("media") String media,
                               @Query("entity") String entity,
                               @Query("limit") String limit);
}
