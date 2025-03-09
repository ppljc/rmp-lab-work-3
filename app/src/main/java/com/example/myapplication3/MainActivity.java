package com.example.myapplication3;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private ImageButton nextButton;
    private int currentImageIndex = 0;
    private int[] images = {R.drawable.image_one, R.drawable.image_two};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_frame);

        imageView = findViewById(R.id.image_view);
        nextButton = findViewById(R.id.next_button);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentImageIndex = (currentImageIndex + 1) % images.length;
                imageView.setImageResource(images[currentImageIndex]);
            }
        });
    }
}