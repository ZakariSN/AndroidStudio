package com.example.android_1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

public class OutputFragment extends Fragment {

    private TextView outputText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_output, container, false);
        outputText = view.findViewById(R.id.text_view_output);
        return view;
    }

    public void updateText(String text) {
        if (outputText != null) {
            outputText.setText(text);
        }
    }
}
