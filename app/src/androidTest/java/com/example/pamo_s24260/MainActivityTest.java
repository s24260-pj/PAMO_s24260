package com.example.pamo_s24260;

import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.*;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.*;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {
    @Test
    public void testFullFlow() {
        ActivityScenario.launch(MainActivity.class);

        onView(withId(R.id.button_bmi_calculator)).perform(click());

        onView(withId(R.id.input_weight)).perform(typeText("70"));
        onView(withId(R.id.input_height)).perform(typeText("175"), closeSoftKeyboard());

        onView(withId(R.id.button)).perform(click());

        onView(withId(R.id.textViewBMI)).check(matches(isDisplayed()));
    }
}
