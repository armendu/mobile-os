package com.example.e07_01;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HttpService {
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/";
    private static PlaceholderService service;

    public static PlaceholderService getService() {
        if (service == null) {
            service = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(PlaceholderService.class);
        }

        return service;
    }
}
