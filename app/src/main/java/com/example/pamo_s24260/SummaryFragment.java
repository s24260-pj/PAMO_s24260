package com.example.pamo_s24260;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.pamo_s24260.databinding.FragmentSummaryBinding;

public class SummaryFragment extends Fragment {

    private FragmentSummaryBinding binding;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSummaryBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView bmiValueTextView = view.findViewById(R.id.textViewBMI);
        TextView statusTextView = view.findViewById(R.id.textViewStatus);

        Bundle bundle = getArguments();
        if (bundle != null && bundle.containsKey("bmi")) {
            float bmi = bundle.getFloat("bmi");

            bmiValueTextView.setText(String.format("BMI: %.2f", bmi));

            String status = getStatusByBMI(bmi);

            statusTextView.setText(status);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private static String getStatusByBMI(float bmi) {
        String status;
        if (bmi < 18.5f) {
            status = "niedowaga";
        } else if (bmi < 25f) {
            status = "optimum";
        } else if (bmi < 30f) {
            status = "nadwaga";
        } else {
            status = "otyłość";
        }
        return status;
    }
}