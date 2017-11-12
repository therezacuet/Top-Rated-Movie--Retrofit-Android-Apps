package com.thereza.retrofitintro.model;

import com.thereza.retrofitintro.data.MovieResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by theReza on 11/11/2017.
 */

public interface ApiInterface {

    @GET("movie/top_rated")
    Call<MovieResponse> getTopRatedMovies(@Query("api_key") String apiKey);

    @GET("movie/{id}")
    Call<MovieResponse> getMovieDetails(@Path("id") int id, @Query("api_key") String apiKey);
}
