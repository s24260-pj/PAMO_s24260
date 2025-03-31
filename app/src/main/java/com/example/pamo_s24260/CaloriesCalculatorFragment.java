package com.example.pamo_s24260;

import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.pamo_s24260.services.Calculator.CaloricRequirementCalculator;
import com.example.pamo_s24260.services.Validator.CaloriesFormValidator;

public class CaloriesCalculatorFragment extends Fragment {
    @Override
    public View onCreateView(
            LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState
    ) {
        CaloricRequirementCalculator caloricRequirementCalculator = new CaloricRequirementCalculator();

        View view = inflater.inflate(R.layout.fragment_calories_calculator, container, false);

        final EditText inputWeight = view.findViewById(R.id.input_weight);
        final EditText inputHeight = view.findViewById(R.id.input_height);
        final EditText inputAge = view.findViewById(R.id.input_age);

        final RadioGroup radioGroupGender = view.findViewById(R.id.radio_group_gender);
        final TextView radioGroupGenderLabel = view.findViewById(R.id.radio_group_gender_label);

        final Spinner spinnerActivityLevel = view.findViewById(R.id.activity_level_spinner);
        final TextView spinnerActivityLevelLabel = view.findViewById(R.id.activity_level_spinner_label);

        final Button submitButton = view.findViewById(R.id.calculate_button);

        String[] activityLevels = getResources().getStringArray(R.array.activity_levels);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_spinner_item, activityLevels);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerActivityLevel.setAdapter(adapter);

        submitButton.setOnClickListener(v -> {
            String weightStr = inputWeight.getText().toString();
            String heightStr = inputHeight.getText().toString();
            String ageStr = inputAge.getText().toString();
            int selectedGenderId = radioGroupGender.getCheckedRadioButtonId();
            int selectedActivityIndex = spinnerActivityLevel.getSelectedItemPosition();

            if (!CaloriesFormValidator.isValidWeight(weightStr)) {
                inputWeight.setError(getString(R.string.error_invalid_weight));
                return;
            }

            if (!CaloriesFormValidator.isValidHeight(heightStr)) {
                inputHeight.setError(getString(R.string.error_invalid_height));
                return;
            }

            if (!CaloriesFormValidator.isValidAge(ageStr)) {
                inputAge.setError(getString(R.string.error_invalid_age));
                return;
            }

            if (!CaloriesFormValidator.isValidGender(selectedGenderId)) {
                radioGroupGenderLabel.setTextColor(ContextCompat.getColor(requireContext(), android.R.color.holo_red_light));
                return;
            } else {
                radioGroupGenderLabel.setTextColor(ContextCompat.getColor(requireContext(), android.R.color.black));
            }

            if (!CaloriesFormValidator.isValidActivityLevel(selectedActivityIndex)) {
                spinnerActivityLevelLabel.setTextColor(ContextCompat.getColor(requireContext(), android.R.color.holo_red_light));
                return;
            } else {
                spinnerActivityLevelLabel.setTextColor(ContextCompat.getColor(requireContext(), android.R.color.black));
            }

            double weight = Double.parseDouble(weightStr);
            double height = Double.parseDouble(heightStr);
            int age = Integer.parseInt(ageStr);

            float totalDailyEnergyExpenditure = caloricRequirementCalculator.calculate(
                    weight,
                    height,
                    age,
                    selectedGenderId,
                    selectedActivityIndex
            );

            var action = CaloriesCalculatorFragmentDirections.caloriesCalculatorToCaloricRequirementSummaryAction(
                    totalDailyEnergyExpenditure
            );

            Navigation.findNavController(v).navigate(action);
        });
        return view;
    }
}