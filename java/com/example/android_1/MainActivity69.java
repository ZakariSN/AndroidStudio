package com.example.android_1;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.*;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity69 extends AppCompatActivity {
EditText ET;
TextView TV;
Button BUT;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main69);

        ET = (EditText) findViewById(R.id.ET);
        TV = (TextView) findViewById(R.id.TV);
        BUT = (Button) findViewById(R.id.BUT);
    }
public void dd(View view) {
    String x = ET.getText().toString();
    TV.setText("the name entered is" + x);
}
    }
