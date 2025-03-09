package com.example.myapplication3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

public class ConstraintFragment extends Fragment {

    private int messageCount = 5;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_constraint, container, false);

        EditText editTextMessage = view.findViewById(R.id.edit_text_message);
        LinearLayout messageContainer = view.findViewById(R.id.message_container);
        ScrollView scrollView = view.findViewById(R.id.scroll_view);
        Button sendButton = view.findViewById(R.id.send_button);

        sendButton.setOnClickListener(v -> {
            String input = editTextMessage.getText().toString();
            if (!input.isEmpty()) {
                TextView textView = new TextView(requireContext());
                textView.setLayoutParams(new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT));
                textView.setText("Message " + (++messageCount));
                int padding = (int) getResources().getDimension(R.dimen.padding_small);
                textView.setPadding(padding, padding, padding, padding);
                messageContainer.addView(textView);
                editTextMessage.setText("");
                scrollView.post(() -> scrollView.fullScroll(View.FOCUS_DOWN));
            }
        });

        return view;
    }
}