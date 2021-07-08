package com.example.e07_01;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PlaceholderService {
    @GET("posts/{id}")
    Call<Post> getPost(@Path("id") int id);

    @GET("posts")
    Call<List<Post>> getPosts();
}
