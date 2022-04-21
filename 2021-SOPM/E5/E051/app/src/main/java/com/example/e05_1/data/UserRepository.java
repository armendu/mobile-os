package com.example.e05_1.data;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class UserRepository {

    private UserDao userDao;
    private LiveData<List<User>> users;

    UserRepository(Application application) {
        AppDatabase db = AppDatabase.getInstance(application);
        userDao = db.userDao();
        users = userDao.getAll();
    }

    public LiveData<List<User>> getUsers() {
        return users;
    }

    public void insert(User user) {
        AppDatabase.databaseWriteExecutor.execute(() -> {
            userDao.insert(user);
        });
    }
}
