package pl.droidsonroids.romannumeralsconverter.presenter;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import pl.droidsonroids.romannumeralsconverter.model.RomanNumeralConverter;
import pl.droidsonroids.romannumeralsconverter.view.MainView;

import static org.mockito.Mockito.only;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

public class MainPresenterImplTest {

    @Mock MainView mainView;

    @Mock RomanNumeralConverter romanNumeralConverter;

    @InjectMocks MainPresenterImpl mainPresenter;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testNumberConversion() throws Exception {
        when(romanNumeralConverter.convert(1)).thenReturn("I");

        mainPresenter.onConvertClick("1");

        verify(romanNumeralConverter, only()).convert(1);
        verify(mainView, only()).displayResult(1, "I");
    }

    @Test
    public void testEmptyStringConversion() throws Exception {
        mainPresenter.onConvertClick("");

        verifyZeroInteractions(romanNumeralConverter);
        verify(mainView, only()).displayInvalidNumberError();
    }

    @Test
    public void testZeroConversion() throws Exception {
        when(romanNumeralConverter.convert(0)).thenThrow(new IllegalStateException());

        mainPresenter.onConvertClick("0");

        verify(romanNumeralConverter, only()).convert(0);
        verify(mainView, only()).displayNonPositiveNumberError();
    }

    @Test
    public void testNonPositiveNumberConversion() throws Exception {
        when(romanNumeralConverter.convert(-1)).thenThrow(new IllegalStateException());

        mainPresenter.onConvertClick("-1");

        verify(romanNumeralConverter, only()).convert(-1);
        verify(mainView, only()).displayNonPositiveNumberError();
    }

    @Test
    public void testOnResume() throws Exception {
        mainPresenter.onResume();
        verifyZeroInteractions(mainView, romanNumeralConverter);
    }
}