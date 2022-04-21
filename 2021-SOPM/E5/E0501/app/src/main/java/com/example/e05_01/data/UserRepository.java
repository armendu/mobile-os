package com.example.e05_01.data;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class UserRepository {

    private UserDao userDao;
    private LiveData<List<User>> users;

    UserRepository(Application application) {
        AppDatabase db = AppDatabase.getDatabase(application);
        userDao = db.userDao();
        users = userDao.getAll();
    }

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    LiveData<List<User>> getAllUsers() {
        return users;
    }

    // You must call this on a non-UI thread or your app will throw an exception. Room ensures
    // that you're not doing any long running operations on the main thread, blocking the UI.
    void insert(User user) {
        AppDatabase.databaseWriteExecutor.execute(() -> {
            userDao.insert(user);
        });
    }
}
