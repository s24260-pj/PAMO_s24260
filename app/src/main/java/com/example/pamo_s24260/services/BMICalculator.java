package com.example.pamo_s24260.services;

public class BMICalculator {
    private static final String ERROR_INVALID_VALUE = "Podaj poprawną wartość";
    private static final String ERROR_REQUIRED_FIELD = "Pole wymagane";

    public float calculateBMI(String weightStr, String heightStr) throws NumberFormatException {
        float weight = Float.parseFloat(weightStr);
        float heightInMeters = Float.parseFloat(heightStr) / 100;
        return weight / (heightInMeters * heightInMeters);
    }

    public String getInvalidValueError() {
        return ERROR_INVALID_VALUE;
    }

    public String getRequiredFieldError() {
        return ERROR_REQUIRED_FIELD;
    }
}
