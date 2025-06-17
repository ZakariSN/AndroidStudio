package com.example.android_1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.android_1.R;




public class calci extends AppCompatActivity {
    TextView calc, disp;
    Button bcl, bbs, b9, b8, b7, b6, b5, b4, b3, b2, b1, b0, bdot, bplus, bminus, bdiv, bmult, bequal;
    String curr, res;
    boolean dot_inserted, operator_inserted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calci);

        curr = "";
        res = "";
        dot_inserted = false;
        operator_inserted = false;

        calc = findViewById(R.id.cal);
        disp = findViewById(R.id.display);
        bcl = findViewById(R.id.idclear);
        bbs = findViewById(R.id.idbackspace);
        b9 = findViewById(R.id.id9);
        b8 = findViewById(R.id.id8);
        b7 = findViewById(R.id.id7);
        b6 = findViewById(R.id.id6);
        b5 = findViewById(R.id.id5);
        b4 = findViewById(R.id.id4);
        b3 = findViewById(R.id.id3);
        b2 = findViewById(R.id.id2);
        b1 = findViewById(R.id.id1);
        b0 = findViewById(R.id.idzero);
        bdot = findViewById(R.id.iddot);
        bplus = findViewById(R.id.idplus);
        bminus = findViewById(R.id.idminus);
        bdiv = findViewById(R.id.iddiv);
        bmult = findViewById(R.id.idmul);
        bequal = findViewById(R.id.idequal);

        View.OnClickListener numberClickListener = v -> {
            Button button = (Button) v;
            curr += button.getText().toString();
            displaycurr();
        };

        b0.setOnClickListener(numberClickListener);
        b1.setOnClickListener(numberClickListener);
        b2.setOnClickListener(numberClickListener);
        b3.setOnClickListener(numberClickListener);
        b4.setOnClickListener(numberClickListener);
        b5.setOnClickListener(numberClickListener);
        b6.setOnClickListener(numberClickListener);
        b7.setOnClickListener(numberClickListener);
        b8.setOnClickListener(numberClickListener);
        b9.setOnClickListener(numberClickListener);

        bdot.setOnClickListener(v -> {
            if (curr.isEmpty()) {
                curr = "0.";
            } else if (!dot_inserted) {
                curr += ".";
            }
            dot_inserted = true;
            displaycurr();
        });

        View.OnClickListener operatorClickListener = v -> {
            Button button = (Button) v;
            if (!curr.isEmpty() && !operator_inserted) {
                if (curr.endsWith(".")) {
                    backspace();
                }
                curr += " " + button.getText().toString() + " ";
                operator_inserted = true;
                dot_inserted = false;
                displaycurr();
            }
        };

        bplus.setOnClickListener(operatorClickListener);
        bminus.setOnClickListener(operatorClickListener);
        bmult.setOnClickListener(operatorClickListener);
        bdiv.setOnClickListener(operatorClickListener);

        bcl.setOnClickListener(v -> {
            clear();
            displaycurr();
            displayres();
        });

        bbs.setOnClickListener(v -> {
            backspace();
            displaycurr();
        });

        bequal.setOnClickListener(v -> {
            if (operator_inserted && !curr.endsWith(" ")) {
                String[] str1 = curr.split(" ");
                try {
                    double num1 = Double.parseDouble(str1[0]);
                    double num2 = Double.parseDouble(str1[2]);
                    char operator = str1[1].charAt(0);

                    switch (operator) {
                        case '+':
                            res = String.valueOf(num1 + num2);
                            break;
                        case '-':
                            res = String.valueOf(num1 - num2);
                            break;
                        case '*':
                            res = String.valueOf(num1 * num2);
                            break;
                        case '/':
                            res = (num2 != 0) ? String.valueOf(num1 / num2) : "Error";
                            break;
                    }
                } catch (Exception e) {
                    res = "Error";
                }
                displayres();
            }
        });
    }

    public void displaycurr() {
        calc.setText(curr);
    }

    public void displayres() {
        disp.setText(res);
    }

    public void clear() {
        curr = "";
        res = "";
        dot_inserted = false;
        operator_inserted = false;
    }

    public void backspace() {
        if (!curr.isEmpty()) {
            if (curr.endsWith(".")) {
                dot_inserted = false;
            }
            if (curr.endsWith(" ")) {
                operator_inserted = false;
                curr = curr.substring(0, curr.length() - 3);
            } else {
                curr = curr.substring(0, curr.length() - 1);
            }
        }
    }
}
