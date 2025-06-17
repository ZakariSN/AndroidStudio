package com.example.android_1;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class Fragtofragtransfer extends AppCompatActivity implements InputFragment.OnTextSendListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragtofragtransfer);


        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_input, new InputFragment())
                .commit();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_output, new OutputFragment())
                .commit();
    }

    @Override
    public void onTextSend(String text) {
        OutputFragment outputFragment = (OutputFragment) getSupportFragmentManager()
                .findFragmentById(R.id.fragment_output);

        if (outputFragment != null) {
            outputFragment.updateText(text);
        }
    }
}
