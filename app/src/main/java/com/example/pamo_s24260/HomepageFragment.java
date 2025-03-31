package com.example.pamo_s24260;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class HomepageFragment extends Fragment {
    @Override
    public View onCreateView(
            LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState
    ) {
        View view =  inflater.inflate(R.layout.fragment_homepage, container, false);

        final TextView firstTextView = view.findViewById(R.id.button_bmi_calculator);
        firstTextView.setOnClickListener(v -> Navigation.findNavController(v).navigate(R.id.homepage_to_bmi_calculator_action));

        final TextView secondTextView = view.findViewById(R.id.button_calorie_calculator);
        secondTextView.setOnClickListener(v -> Navigation.findNavController(v).navigate(R.id.homepage_to_calories_calculator_action));

        return view;
    }
}