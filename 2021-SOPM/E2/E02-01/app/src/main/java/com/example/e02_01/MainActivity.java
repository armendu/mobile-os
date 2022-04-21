package com.example.e02_01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    final String FULL_NAME_KEY = "FULL_NAME_KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button submitButton = findViewById(R.id.submit_button);
        EditText submittedName = findViewById(R.id.full_name);

        submitButton.setOnClickListener(view -> {
            String fullName = submittedName.getText().toString().trim();

            if (!fullName.isEmpty())
            {
                Intent intent = new Intent(this, WelcomeActivity.class);
                intent.putExtra(FULL_NAME_KEY, fullName);

                startActivity(intent);
            }
        });
    }
}