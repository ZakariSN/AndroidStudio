package com.example.android_1;

import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class daterpicker extends AppCompatActivity {
    DatePicker DP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_daterpicker);
        DP=(DatePicker) findViewById(R.id.dpicker);

    }
    public void cale(View view)
    {
        int day=DP.getDayOfMonth();
        int month=DP.getMonth()+1;
        int year= DP.getYear();
        Toast.makeText(this, "The day,month,year is "+day +month +year, Toast.LENGTH_SHORT).show();
    }
}