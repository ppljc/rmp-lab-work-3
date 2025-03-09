package com.example.myapplication3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;

public class FrameFragment extends Fragment {

    private int currentImageIndex = 0;
    private int[] images = {R.drawable.image_one, R.drawable.image_two};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_frame, container, false);

        ImageView imageView = view.findViewById(R.id.image_view);
        ImageButton nextButton = view.findViewById(R.id.next_button);

        nextButton.setOnClickListener(v -> {
            currentImageIndex = (currentImageIndex + 1) % images.length;
            imageView.setImageResource(images[currentImageIndex]);
        });

        return view;
    }
}