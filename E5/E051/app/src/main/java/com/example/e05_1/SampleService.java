package com.example.e05_1;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface SampleService {

    @GET("posts/{id}")
    Call<Post> getPost(@Path("id") int id);

//    public static class OurService {
//        private static String BASE_URL = "https://jsonplaceholder.typicode.com/";
//
//        SampleService create() {
//            return new Retrofit.Builder()
//                    .baseUrl(BASE_URL)
//                    .build()
//                    .create(SampleService.class);
//        }
//    }
}
