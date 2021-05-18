package com.example.sampleapp;


import android.app.Activity;
import android.os.Bundle;

public class NewActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_activity);
    }
}
