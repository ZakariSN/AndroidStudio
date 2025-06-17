package com.example.android_1;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import androidx.fragment.app.Fragment;

public class InputFragment extends Fragment {

    private OnTextSendListener callback;

    public interface OnTextSendListener {
        void onTextSend(String text);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnTextSendListener) {
            callback = (OnTextSendListener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement OnTextSendListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_input, container, false);

        EditText inputText = view.findViewById(R.id.edit_text_input);
        Button sendButton = view.findViewById(R.id.button_send);

        sendButton.setOnClickListener(v -> {
            String text = inputText.getText().toString();
            callback.onTextSend(text);
        });

        return view;
    }
}
