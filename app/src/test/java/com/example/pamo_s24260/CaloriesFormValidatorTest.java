package com.example.pamo_s24260;

import static org.junit.Assert.*;

import android.widget.Spinner;

import com.example.pamo_s24260.services.Validator.CaloriesFormValidator;

import org.junit.Test;

public class CaloriesFormValidatorTest {

    @Test
    public void testIsValidWeight_valid() {
        assertTrue(CaloriesFormValidator.isValidWeight("70.5"));
    }

    @Test
    public void testIsValidWeight_invalidEmpty() {
        assertFalse(CaloriesFormValidator.isValidWeight(""));
    }

    @Test
    public void testIsValidWeight_invalidNonNumeric() {
        assertFalse(CaloriesFormValidator.isValidWeight("abc"));
    }

    @Test
    public void testIsValidHeight_valid() {
        assertTrue(CaloriesFormValidator.isValidHeight("180"));
    }

    @Test
    public void testIsValidHeight_invalidEmpty() {
        assertFalse(CaloriesFormValidator.isValidHeight(""));
    }

    @Test
    public void testIsValidHeight_invalidNonNumeric() {
        assertFalse(CaloriesFormValidator.isValidHeight("one eighty"));
    }

    @Test
    public void testIsValidAge_valid() {
        assertTrue(CaloriesFormValidator.isValidAge("25"));
    }

    @Test
    public void testIsValidAge_invalidEmpty() {
        assertFalse(CaloriesFormValidator.isValidAge(""));
    }

    @Test
    public void testIsValidAge_invalidNonNumeric() {
        assertFalse(CaloriesFormValidator.isValidAge("twenty-five"));
    }

    @Test
    public void testIsValidGender_valid() {
        assertTrue(CaloriesFormValidator.isValidGender(1));
    }

    @Test
    public void testIsValidGender_invalid() {
        assertFalse(CaloriesFormValidator.isValidGender(-1));
    }

    @Test
    public void testIsValidActivityLevel_valid() {
        assertTrue(CaloriesFormValidator.isValidActivityLevel(2));
    }

    @Test
    public void testIsValidActivityLevel_invalid() {
        assertFalse(CaloriesFormValidator.isValidActivityLevel(Spinner.INVALID_POSITION));
    }
}
