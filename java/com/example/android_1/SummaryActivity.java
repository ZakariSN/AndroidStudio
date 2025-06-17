package com.example.android_1;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;

public class SummaryActivity extends AppCompatActivity {

    TextView workoutSummary, calorieSummary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        // Initialize UI components
        workoutSummary = findViewById(R.id.workoutSummary);
        calorieSummary = findViewById(R.id.calorieSummary);

        // Placeholder values for summaries
        workoutSummary.setText("Workout Summary: Coming soon...");
        calorieSummary.setText("Calorie Summary: Coming soon...");
    }
}