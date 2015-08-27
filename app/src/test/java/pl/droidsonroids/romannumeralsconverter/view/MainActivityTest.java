package pl.droidsonroids.romannumeralsconverter.view;

import android.app.Activity;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import javax.inject.Inject;

import pl.droidsonroids.romannumeralsconverter.BuildConfig;
import pl.droidsonroids.romannumeralsconverter.R;
import pl.droidsonroids.romannumeralsconverter.presenter.MainPresenter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class MainActivityTest {

    @Inject MainPresenter mainPresenter;

    private TestMainActivity activity;

    @Before
    public void setUp() throws Exception {
        activity = Robolectric.setupActivity(TestMainActivity.class);
        activity.inject(this);

        verify(mainPresenter).onResume();
    }

    @Test
    public void testLifecycle() throws Exception {
        Activity activity = Robolectric.buildActivity(TestMainActivity.class)
                .create()
                .start()
                .resume()
                .pause()
                .stop()
                .destroy()
                .visible()
                .get();
        assertNotNull(activity);
    }

    @Test
    public void testOnConvertClick() throws Exception {
        activity.numberEdit.setText("1");
        activity.convertButton.performClick();

        verify(mainPresenter).onConvertClick("1");
        verifyNoMoreInteractions(mainPresenter);
    }

    @Test
    public void testDisplayResult() throws Exception {
        activity.displayResult(1, "I");
        assertEquals(getString(R.string.result, 1, "I"), activity.resultText.getText().toString());
    }

    @Test
    public void testDisplayInvalidNumberError() throws Exception {
        activity.displayInvalidNumberError();
        assertEquals(getString(R.string.error_invalid_number), activity.resultText.getText().toString());
    }

    @Test
    public void testDisplayNonPositiveNumberError() throws Exception {
        activity.displayNonPositiveNumberError();
        assertEquals(getString(R.string.error_non_positive_number), activity.resultText.getText().toString());
    }

    private String getString(final int stringResId, final Object... formatArgs) {
        return RuntimeEnvironment.application.getString(stringResId, formatArgs);
    }

    private String getString(final int stringResId) {
        return RuntimeEnvironment.application.getString(stringResId);
    }
}