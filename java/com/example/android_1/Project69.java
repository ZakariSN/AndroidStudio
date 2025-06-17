package com.example.android_1;



import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class Project69 extends AppCompatActivity {


    EditText workoutInput, calorieProtein, calorieCarbs, calorieFats, calorieFiber, stepCountInput;
    Button trackWorkout, calculateCalories, updateGraphButton;


    com.example.android_1.CustomBarChartView workoutBarChart;
    com.example.android_1.CustomGraphView stepLineGraph;
    com.example.android_1.CustomPieChartView caloriePieChart;


    List<String> workoutHistory = new ArrayList<>();
    List<Integer> stepEntries = new ArrayList<>();
    int cumulativeSteps = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project69);


        workoutInput = findViewById(R.id.workoutInput);
        calorieProtein = findViewById(R.id.calorieProtein);
        calorieCarbs = findViewById(R.id.calorieCarbs);
        calorieFats = findViewById(R.id.calorieFats);
        calorieFiber = findViewById(R.id.calorieFiber);
        stepCountInput = findViewById(R.id.stepCountInput);

        trackWorkout = findViewById(R.id.trackWorkout);
        calculateCalories = findViewById(R.id.calculateCalories);
        updateGraphButton = findViewById(R.id.updateGraphButton);

        workoutBarChart = findViewById(R.id.workoutBarChart);
        stepLineGraph = findViewById(R.id.stepLineGraph);
        caloriePieChart = findViewById(R.id.caloriePieChart);


        trackWorkout.setOnClickListener(v -> {
            String workoutDetails = workoutInput.getText().toString();
            if (!workoutDetails.isEmpty()) {
                workoutHistory.add(workoutDetails);
                workoutBarChart.updateBarChart(workoutHistory);
                Toast.makeText(this, "Workout tracked: " + workoutDetails, Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Enter workout details!", Toast.LENGTH_SHORT).show();
            }
        });


        calculateCalories.setOnClickListener(v -> {
            try {
                int protein = Integer.parseInt(calorieProtein.getText().toString());
                int carbs = Integer.parseInt(calorieCarbs.getText().toString());
                int fats = Integer.parseInt(calorieFats.getText().toString());
                int fiber = Integer.parseInt(calorieFiber.getText().toString());

                int totalCalories = (protein * 4) + (carbs * 4) + (fats * 9) + (fiber * 2);
                caloriePieChart.updatePieChart(protein, carbs, fats, fiber);
                Toast.makeText(this, "Total Calories: " + totalCalories, Toast.LENGTH_SHORT).show();
            } catch (NumberFormatException e) {
                Toast.makeText(this, "Enter valid calorie values!", Toast.LENGTH_SHORT).show();
            }
        });


        updateGraphButton.setOnClickListener(v -> {
            try {
                int stepCount = Integer.parseInt(stepCountInput.getText().toString());
                cumulativeSteps += stepCount;
                stepEntries.add(cumulativeSteps);
                stepLineGraph.updateGraph(stepEntries);
                Toast.makeText(this, "Step tracker updated! Total: " + cumulativeSteps + " steps.", Toast.LENGTH_SHORT).show();
            } catch (NumberFormatException e) {
                Toast.makeText(this, "Enter valid steps!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}