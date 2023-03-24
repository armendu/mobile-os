package com.example.e05_1.data;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = { User.class }, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();

    private static volatile AppDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;

    static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static AppDatabase getInstance(final Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context, AppDatabase.class, "sample-db").addCallback(roomDatabaseCallback).build();
                }
            }
        }

        return INSTANCE;
    }

    private static RoomDatabase.Callback roomDatabaseCallback = new Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            databaseWriteExecutor.execute(() -> {
                UserDao userDao = INSTANCE.userDao();

                User userToAdd = new User();
                userToAdd.setId(1);
                userToAdd.setName("Studenti1");
                userToAdd.setLastName("StudentiLastname1");
                userToAdd.setPosition("Position1");

                userDao.insert(userToAdd);
            });
        }
    };
}
