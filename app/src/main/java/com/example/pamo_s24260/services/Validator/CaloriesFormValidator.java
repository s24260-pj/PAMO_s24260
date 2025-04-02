package com.example.pamo_s24260.services.Validator;

import android.widget.Spinner;

public class CaloriesFormValidator {
    public static boolean isValidWeight(String weightStr) {
        if (weightStr.isEmpty()) {
            return false;
        }
        try {
            Double.parseDouble(weightStr);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public static boolean isValidHeight(String heightStr) {
        if (heightStr.isEmpty()) {
            return false;
        }
        try {
            Double.parseDouble(heightStr);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public static boolean isValidAge(String ageStr) {
        if (ageStr.isEmpty()) {
            return false;
        }
        try {
            Integer.parseInt(ageStr);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public static boolean isValidGender(int selectedGenderId) {
        return selectedGenderId != -1;
    }

    public static boolean isValidActivityLevel(int selectedActivityIndex) {
        return selectedActivityIndex != Spinner.INVALID_POSITION;
    }
}
