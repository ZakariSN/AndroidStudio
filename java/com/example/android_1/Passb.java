package com.example.android_1;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Passb extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passb);

        TextView textViewName = findViewById(R.id.textViewName);

        // Retrieve the passed name
        String name = getIntent().getStringExtra("USER_NAME");
        textViewName.setText("Hello, " + name + "!");
    }
}