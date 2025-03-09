package com.example.myapplication3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextMessage;
    private GridLayout gridLayout;
    private int messageIndex = 5; // Следующий индекс для перезаписи

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_grid);

        editTextMessage = findViewById(R.id.edit_text_message);
        gridLayout = findViewById(R.id.grid_layout);
        Button sendButton = findViewById(R.id.send_button);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = editTextMessage.getText().toString();
                if (!message.isEmpty()) {
                    int row = messageIndex % 5; // Циклическая перезапись (0-4)
                    TextView textView = (TextView) gridLayout.getChildAt(row);
                    textView.setText(message);
                    messageIndex++;
                    editTextMessage.setText("");
                }
            }
        });
    }
}