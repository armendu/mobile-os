package com.example.e02_01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity {

    final String FULL_NAME_KEY = "FULL_NAME_KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        Intent mainActivityIntent = getIntent();

        if (mainActivityIntent != null) {
            String name = mainActivityIntent.getStringExtra(FULL_NAME_KEY);
            TextView welcomeMessage = findViewById(R.id.welcome_text);

            String welcomeTextToDisplay = getString(R.string.welcome_text, name);
            welcomeMessage.setText(welcomeTextToDisplay);
        }
    }
}