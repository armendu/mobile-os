package com.example.e05_01.data;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class UserViewModel extends AndroidViewModel {

    private UserRepository mRepository;

    private final LiveData<List<User>> mAllUsers;

    public UserViewModel(@NonNull Application application) {
        super(application);

        mRepository = new UserRepository(application);
        mAllUsers = mRepository.getAllUsers();
    }

    public LiveData<List<User>> getAllWords() { return mAllUsers; }

    public void insert(User user) { mRepository.insert(user); }
}
