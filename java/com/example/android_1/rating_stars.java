package com.example.android_1;

import android.os.Bundle;
import android.view.View;
import android.widget.RatingBar;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class rating_stars extends AppCompatActivity {
RatingBar rb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_rating_stars);
        rb=(RatingBar) findViewById(R.id.id1);

    }
    public void stars(View view )
    {
        float r=rb.getRating();
        Toast.makeText(this, "The rating given is "+r, Toast.LENGTH_SHORT).show();
    }
}