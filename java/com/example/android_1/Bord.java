package com.example.android_1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Bord extends AppCompatActivity {

    private EditText amountInput;
    private TextView balanceText;
    private double balance = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bord);

        amountInput = findViewById(R.id.amountInput);
        balanceText = findViewById(R.id.balanceText);
        Button addIncomeButton = findViewById(R.id.addIncomeButton);
        Button addExpenseButton = findViewById(R.id.addExpenseButton);

        updateBalanceText();

        addIncomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateBalance(true);
            }
        });

        addExpenseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateBalance(false);
            }
        });
    }

    private void updateBalance(boolean isIncome) {
        String amountStr = amountInput.getText().toString().trim();
        if (!amountStr.isEmpty()) {
            double amount = Double.parseDouble(amountStr);
            balance += isIncome ? amount : -amount;
            updateBalanceText();
            amountInput.setText("");
        }
    }

    private void updateBalanceText() {
        balanceText.setText("Balance: $" + String.format("%.2f", balance));
    }
}
