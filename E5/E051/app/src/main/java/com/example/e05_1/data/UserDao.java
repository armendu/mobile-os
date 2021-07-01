package com.example.e05_1.data;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface UserDao {

    @Query("SELECT * FROM users")
    List<User> getAll();

    @Query("SELECT * FROM users WHERE id=:id")
    User getById(int id);

    @Query("SELECT * FROM users WHERE name LIKE :name")
    User findByName(String name);

    @Insert
    void insert(User... user);

    @Delete
    void delete(User user);

    @Update
    void update(User user);
}
