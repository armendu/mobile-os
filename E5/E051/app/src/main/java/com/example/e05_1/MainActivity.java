package com.example.e05_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.e05_1.data.User;
import com.example.e05_1.data.UserViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;

import java.util.List;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private static String BASE_URL = "https://jsonplaceholder.typicode.com/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView outTextView = findViewById(R.id.test_view);

        // Get ViewModel
         UserViewModel userViewModel = new ViewModelProvider(this).get(UserViewModel.class);

        // Log the existing data
        userViewModel.getAllUsers().observe(this, users -> {
            // adapter.setData(users);
            StringBuilder builder = new StringBuilder();
            outTextView.setText("");
            for (User user : users) {
                builder.append(user.getName()).append(", ");
            }

            outTextView.setText(builder.toString());
        });

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(view -> {
            // Insert new user
            User userToAdd = new User();
            Random random = new Random();
            int number = random.nextInt();
            userToAdd.setName("StudentiTjeter" + number);
            userViewModel.createUser(userToAdd);
        });

        SampleService service = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(SampleService.class);

        service.getPost(1).enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if (response.isSuccessful()) {
                    Log.d("MainActivity", "Message: " + response.body().getTitle());
                }
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {

            }
        });
    }
}