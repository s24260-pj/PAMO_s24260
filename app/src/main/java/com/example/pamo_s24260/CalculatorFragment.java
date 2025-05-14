package com.example.pamo_s24260;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.pamo_s24260.databinding.FragmentCalculatorBinding;
import com.example.pamo_s24260.services.BMICalculator;

public class CalculatorFragment extends Fragment {
    private FragmentCalculatorBinding binding;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentCalculatorBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final EditText inputWeight = view.findViewById(R.id.input_weight);
        final EditText inputHeight = view.findViewById(R.id.input_height);
        BMICalculator bmiService = new BMICalculator();

        binding.button.setOnClickListener(v -> {
            String weightStr = inputWeight.getText().toString();
            String heightStr = inputHeight.getText().toString();

            if (!weightStr.isEmpty() && !heightStr.isEmpty()) {
                try {
                    float bmi = bmiService.calculateBMI(weightStr, heightStr);

                    Bundle bundle = new Bundle();
                    bundle.putFloat("bmi", bmi);
                    Navigation.findNavController(v).navigate(R.id.calculator_to_summary_action, bundle);

                } catch (NumberFormatException e) {
                    inputWeight.setError(bmiService.getInvalidValueError());
                    inputHeight.setError(bmiService.getInvalidValueError());
                }
            } else {
                if (weightStr.isEmpty()) {
                    inputWeight.setError(bmiService.getRequiredFieldError());
                }
                if (heightStr.isEmpty()) {
                    inputHeight.setError(bmiService.getRequiredFieldError());
                }
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}