package com.example.android_1;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;

class Project2 extends AppCompatActivity {

    private EditText caloriesInput, proteinInput, carbsInput, fatsInput, fiberInput, stepsInput, workoutInput;
    private TextView caloriesDisplay, proteinDisplay, carbsDisplay, fatsDisplay, fiberDisplay, stepsDisplay;
    private RecyclerView workoutRecyclerView;
    private WorkoutAdapter workoutAdapter;
    private List<String> workoutList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project); // Corrected layout reference

        caloriesInput = findViewById(R.id.caloriesInput);
        proteinInput = findViewById(R.id.proteinInput);
        carbsInput = findViewById(R.id.carbsInput);
        fatsInput = findViewById(R.id.fatsInput);
        fiberInput = findViewById(R.id.fiberInput);
        stepsInput = findViewById(R.id.stepsInput);
        workoutInput = findViewById(R.id.workoutInput);

        caloriesDisplay = findViewById(R.id.caloriesDisplay);
        proteinDisplay = findViewById(R.id.proteinDisplay);
        carbsDisplay = findViewById(R.id.carbsDisplay);
        fatsDisplay = findViewById(R.id.fatsDisplay);
        fiberDisplay = findViewById(R.id.fiberDisplay);
        stepsDisplay = findViewById(R.id.stepsDisplay);

        workoutRecyclerView = findViewById(R.id.workoutRecyclerView);
        workoutRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        workoutList = new ArrayList<>();
        workoutAdapter = new WorkoutAdapter(workoutList);
        workoutRecyclerView.setAdapter(workoutAdapter);

        Button updateButton = findViewById(R.id.updateButton);
        Button addWorkoutButton = findViewById(R.id.addWorkoutButton);

        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateValues();
            }
        });

        addWorkoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addWorkout();
            }
        });
    }

    private void updateValues() {
        try {
            caloriesDisplay.setText("Calories: " + caloriesInput.getText().toString());
            proteinDisplay.setText("Protein: " + proteinInput.getText().toString());
            carbsDisplay.setText("Carbs: " + carbsInput.getText().toString());
            fatsDisplay.setText("Fats: " + fatsInput.getText().toString());
            fiberDisplay.setText("Fiber: " + fiberInput.getText().toString());
            stepsDisplay.setText("Steps: " + stepsInput.getText().toString());
        } catch (Exception e) {
            Toast.makeText(this, "Please enter valid numbers.", Toast.LENGTH_SHORT).show();
        }
    }

    private void addWorkout() {
        String workout = workoutInput.getText().toString().trim();
        if (!workout.isEmpty()) {
            workoutList.add(workout);
            workoutAdapter.notifyDataSetChanged();
            workoutInput.setText("");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_clear) {
            workoutList.clear();
            workoutAdapter.notifyDataSetChanged();
            caloriesDisplay.setText("Calories: ");
            proteinDisplay.setText("Protein: ");
            carbsDisplay.setText("Carbs: ");
            fatsDisplay.setText("Fats: ");
            fiberDisplay.setText("Fiber: ");
            stepsDisplay.setText("Steps: ");
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    // Inner class for WorkoutAdapter
    private class WorkoutAdapter extends RecyclerView.Adapter<WorkoutAdapter.WorkoutViewHolder> {

        private List<String> workoutList;

        public WorkoutAdapter(List<String> workoutList) {
            this.workoutList = workoutList;
        }

        @NonNull
        @Override
        public WorkoutViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.workout_item, parent, false);
            return new WorkoutViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull WorkoutViewHolder holder, int position) {
            holder.workoutTextView.setText(workoutList.get(position));
        }

        @Override
        public int getItemCount() {
            return workoutList.size();
        }

        class WorkoutViewHolder extends RecyclerView.ViewHolder {
            TextView workoutTextView;

            public WorkoutViewHolder(@NonNull View itemView) {
                super(itemView);
                workoutTextView = itemView.findViewById(R.id.workoutTextView);
            }
        }
    }
}