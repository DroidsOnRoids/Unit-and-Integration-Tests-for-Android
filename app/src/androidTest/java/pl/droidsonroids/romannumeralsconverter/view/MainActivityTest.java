package pl.droidsonroids.romannumeralsconverter.view;

import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.test.ActivityInstrumentationTestCase2;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import pl.droidsonroids.romannumeralsconverter.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {

    public MainActivityTest() {
        super(MainActivity.class);
    }

    @Before
    public void setUp() throws Exception {
        super.setUp();
        injectInstrumentation(InstrumentationRegistry.getInstrumentation());
        getActivity();
    }

    @Test
    public void testConversion1() throws Exception {
        onView(withId(R.id.number)).perform(typeText("1"));
        onView(withText(R.string.convert)).perform(click());
        onView(withId(R.id.result)).check(matches(isDisplayed()));
        onView(withId(R.id.result)).check(matches(withText(getActivity().getString(R.string.result, 1, "I"))));
    }

    @Test
    public void testConversion01() throws Exception {
        onView(withId(R.id.number)).perform(typeText("01"));
        onView(withText(R.string.convert)).perform(click());
        onView(withId(R.id.result)).check(matches(isDisplayed()));
        onView(withId(R.id.result)).check(matches(withText(getActivity().getString(R.string.result, 1, "I"))));
    }

    @Test
    public void testConversion1999() throws Exception {
        onView(withId(R.id.number)).perform(typeText("1999"));
        onView(withText(R.string.convert)).perform(click());
        onView(withId(R.id.result)).check(matches(isDisplayed()));
        onView(withId(R.id.result)).check(matches(withText(getActivity().getString(R.string.result, 1999, "MCMXCIX"))));
    }

    @Test
    public void testInvalidNumberConversion() throws Exception {
        onView(withId(R.id.number)).perform(replaceText(""));
        onView(withText(R.string.convert)).perform(click());
        onView(withId(R.id.result)).check(matches(isDisplayed()));
        onView(withId(R.id.result)).check(matches(withText(R.string.error_invalid_number)));
    }

    @Test
    public void testZeroConversion() throws Exception {
        onView(withId(R.id.number)).perform(typeText("0"));
        onView(withText(R.string.convert)).perform(click());
        onView(withId(R.id.result)).check(matches(isDisplayed()));
        onView(withId(R.id.result)).check(matches(withText(R.string.error_non_positive_number)));
    }

    @Test
    public void testNegativeNumberConversion() throws Exception {
        onView(withId(R.id.number)).perform(typeText("-1"));
        onView(withText(R.string.convert)).perform(click());
        onView(withId(R.id.result)).check(matches(isDisplayed()));
        onView(withId(R.id.result)).check(matches(withText(getActivity().getString(R.string.result, 1, "I"))));
    }
}