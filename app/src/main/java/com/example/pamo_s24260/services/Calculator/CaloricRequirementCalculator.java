package com.example.pamo_s24260.services.Calculator;

import com.example.pamo_s24260.R;

public class CaloricRequirementCalculator {
    public double calculate(
            double weight,
            double height,
            int age,
            int selectedGenderId,
            int selectedActivityIndex
    ) {
        double activityFactor = this.getActivityFactorByActivityIndex(selectedActivityIndex);
        double bmr = this.getBMRBySelectedGenderId(
                selectedGenderId,
                weight,
                height,
                age
        );

        return bmr * activityFactor;
    }

    private double getActivityFactorByActivityIndex(int index) {
        switch (index) {
            case 1:
                return 1.375;
            case 2:
                return 1.55;
            case 3:
                return 1.725;
            case 0:
            default:
                return 1.2;
        }
    }

    private double getBMRBySelectedGenderId(double id, double weight, double height, double age) {
        if (id == R.id.radio_male) {
            return 88.362 + (13.397 * weight) + (4.799 * height) - (5.677 * age);
        }

        return 447.593 + (9.247 * weight) + (3.098 * height) - (4.330 * age);
    }
}
