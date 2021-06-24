package com.example.e05_01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.room.Room;

import android.os.Bundle;
import android.util.Log;

import com.example.e05_01.data.AppDatabase;
import com.example.e05_01.data.User;
import com.example.e05_01.data.UserDao;
import com.example.e05_01.data.UserViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private UserViewModel mWordViewModel;

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
    }
}