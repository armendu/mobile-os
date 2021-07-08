package com.example.e05_01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.room.Room;

import android.os.Bundle;
import android.util.Log;

import com.example.e05_01.data.AppDatabase;
import com.example.e05_01.data.Post;
import com.example.e05_01.data.User;
import com.example.e05_01.data.UserDao;
import com.example.e05_01.data.UserViewModel;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private UserViewModel mWordViewModel;

    public static final String BASE_URL = "https://jsonplaceholder.typicode.com/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // When your Activity first starts, the ViewModelProviders will create the ViewModel.
        // When the activity is destroyed, for example through a configuration change,
        // the ViewModel persists.
        mWordViewModel = new ViewModelProvider(this).get(UserViewModel.class);

        User user1 = new User();
        user1.setName("Armend");
        user1.setLastName("Lastname");
        user1.setPosition("position");

        mWordViewModel.insert(user1);

        mWordViewModel.getAllWords().observe(this, users -> {
            // Update the cached copy of the words in the adapter.
            for (User user : users) {
                Log.d("MainActivity", user.getName());
            }
        });


        // Retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MyApiEndpointInterface service = retrofit.create(MyApiEndpointInterface.class);

        Response<Post> post = null;
        service.getUser(1).enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if (response.isSuccessful()) {
                    Log.d("MainActivity", "message" + response.body().getBody());
                }
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                Log.d("MainActivity", t.getMessage());
            }
        });
    }
}