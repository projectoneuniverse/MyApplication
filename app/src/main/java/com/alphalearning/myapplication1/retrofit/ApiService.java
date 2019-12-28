package com.alphalearning.myapplication1.retrofit;

import com.alphalearning.myapplication1.model.ResponseMovies;

import java.util.Locale;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("movie/popular")

    Call<ResponseMovies> ambilDataMovie(
            @Query("api_key") String apikey
    );
}
