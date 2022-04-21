package com.example.e05_1.data;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class UserViewModel extends AndroidViewModel {

    private final LiveData<List<User>> allUsers;
    private UserRepository userRepository;

    public UserViewModel(@NonNull Application application) {
        super(application);

        userRepository = new UserRepository(application);
        allUsers = userRepository.getUsers();
    }

    public LiveData<List<User>> getAllUsers() {
        return allUsers;
    }

    public void createUser(User user) {
        userRepository.insert(user);
    }
}
