package com.example.android_1;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class project extends AppCompatActivity {

    EditText expenseInput, amountInput;
    Button addButton;
    ListView expenseList;
    TextView totalAmount;

    ArrayList<String> expenseItems;
    ArrayAdapter<String> adapter;

    double total = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project);

        expenseInput = findViewById(R.id.expenseInput);
        amountInput = findViewById(R.id.amountInput);
        addButton = findViewById(R.id.addButton);
        expenseList = findViewById(R.id.expenseList);
        totalAmount = findViewById(R.id.totalAmount);

        expenseItems = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, expenseItems);
        expenseList.setAdapter(adapter);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String expenseName = expenseInput.getText().toString().trim();
                String amountStr = amountInput.getText().toString().trim();

                if (expenseName.isEmpty() || amountStr.isEmpty()) {
                    Toast.makeText(project.this, "Please enter both name and amount", Toast.LENGTH_SHORT).show();
                    return;
                }

                try {
                    double amount = Double.parseDouble(amountStr);
                    total += amount;
                    String entry = expenseName + " - ₹" + String.format("%.2f", amount);
                    expenseItems.add(entry);
                    adapter.notifyDataSetChanged();
                    totalAmount.setText("₹" + String.format("%.2f", total));
                    expenseInput.setText("");
                    amountInput.setText("");
                } catch (NumberFormatException e) {
                    Toast.makeText(project.this, "Invalid amount format", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}