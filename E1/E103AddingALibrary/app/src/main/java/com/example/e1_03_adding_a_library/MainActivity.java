package com.example.e1_03_adding_a_library;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.mackhartley.roundedprogressbar.RoundedProgressBar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RoundedProgressBar roundedProgressBar = findViewById(R.id.rounded_progress_bar);

        roundedProgressBar.setProgressPercentage(50.00, true);
    }
}