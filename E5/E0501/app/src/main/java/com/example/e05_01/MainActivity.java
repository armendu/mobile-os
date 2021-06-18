package com.example.e05_01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;

import com.example.e05_01.data.AppDatabase;
import com.example.e05_01.data.User;
import com.example.e05_01.data.UserDao;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "database-name").build();

        UserDao userDao = db.userDao();
        List<User> users = userDao.getAll();


    }
}