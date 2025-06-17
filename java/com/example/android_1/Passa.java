package com.example.android_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Passa extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passa);

        EditText editTextName = findViewById(R.id.editTextName);
        Button buttonSend = findViewById(R.id.buttonSend);

        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextName.getText().toString();

                // Create intent to send name to Passb
                Intent intent = new Intent(Passa.this, Passb.class);
                intent.putExtra("USER_NAME", name);
                startActivity(intent);
            }
        });
    }
}