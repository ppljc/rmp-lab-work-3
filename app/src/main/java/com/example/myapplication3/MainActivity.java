package com.example.myapplication3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextMessage;
    private LinearLayout messageContainer;
    private ScrollView scrollView;
    private int messageCount = 5; // Начинаем с 5, так как уже есть 5 сообщений

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextMessage = findViewById(R.id.edit_text_message);
        messageContainer = findViewById(R.id.message_container);
        scrollView = findViewById(R.id.scroll_view);
        Button sendButton = findViewById(R.id.send_button);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = editTextMessage.getText().toString();
                if (!input.isEmpty()) {
                    TextView textView = new TextView(MainActivity.this);
                    textView.setLayoutParams(new LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.WRAP_CONTENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT));
                    textView.setText("Message " + (++messageCount));
                    int padding = (int) getResources().getDimension(R.dimen.padding_small);
                    textView.setPadding(padding, padding, padding, padding);
                    messageContainer.addView(textView);
                    editTextMessage.setText("");
                    scrollView.post(new Runnable() {
                        @Override
                        public void run() {
                            scrollView.fullScroll(View.FOCUS_DOWN);
                        }
                    });
                }
            }
        });
    }
}