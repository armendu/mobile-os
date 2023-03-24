package com.example.e104_ui_greeting;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MaterialButton loginButton = findViewById(R.id.login_button);

        loginButton.setOnClickListener(view -> Toast.makeText(MainActivity.this, "test", Toast.LENGTH_LONG).show());

    }
}