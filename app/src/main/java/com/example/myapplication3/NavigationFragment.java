package com.example.myapplication3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.fragment.app.Fragment;

public class NavigationFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_navigation, container, false);

        Button buttonLinear = view.findViewById(R.id.button_linear);
        Button buttonConstraint = view.findViewById(R.id.button_constraint);
        Button buttonFrame = view.findViewById(R.id.button_frame);

        buttonLinear.setOnClickListener(v -> {
            requireActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new LinearFragment())
                    .addToBackStack(null)
                    .commit();
        });

        buttonConstraint.setOnClickListener(v -> {
            requireActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new ConstraintFragment())
                    .addToBackStack(null)
                    .commit();
        });

        buttonFrame.setOnClickListener(v -> {
            requireActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new FrameFragment())
                    .addToBackStack(null)
                    .commit();
        });

        return view;
    }
}