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
        View view = inflater.inflate(R.layout.fragment_homepage, container, false);

        final TextView bmiCalculatorButton = view.findViewById(R.id.button_bmi_calculator);
        bmiCalculatorButton.setOnClickListener(v -> Navigation.findNavController(v).navigate(R.id.homepage_to_bmi_calculator_action));

        final TextView calorieCalculatorButton = view.findViewById(R.id.button_calorie_calculator);
        calorieCalculatorButton.setOnClickListener(v -> Navigation.findNavController(v).navigate(R.id.homepage_to_calories_calculator_action));

        final TextView shoppingListButton = view.findViewById(R.id.button_shopping_list);
        shoppingListButton.setOnClickListener(v -> Navigation.findNavController(v).navigate(R.id.homepage_to_shopping_list_action));

        final TextView bmiChartButton = view.findViewById(R.id.button_bmi_chart);
        bmiChartButton.setOnClickListener(v -> Navigation.findNavController(v).navigate(R.id.homepage_to_bmi_chart_action));

        return view;
    }
}