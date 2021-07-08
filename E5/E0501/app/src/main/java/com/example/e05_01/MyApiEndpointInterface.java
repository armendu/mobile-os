package com.example.e05_01;

import com.example.e05_01.data.Post;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface MyApiEndpointInterface {
    @GET("posts/{id}")
    Call<Post> getUser(@Path("id") int id);
}
