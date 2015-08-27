package pl.droidsonroids.romannumeralsconverter.presenter;

import pl.droidsonroids.romannumeralsconverter.model.RomanNumeralConverter;
import pl.droidsonroids.romannumeralsconverter.view.MainView;

public class MainPresenterImpl implements MainPresenter {

    private final MainView mainView;

    private final RomanNumeralConverter romanNumeralConverter;

    public MainPresenterImpl(final MainView mainView, final RomanNumeralConverter romanNumeralConverter) {
        this.mainView = mainView;
        this.romanNumeralConverter = romanNumeralConverter;
    }

    @Override
    public void onConvertClick(final String arabicNumberString) {
        try {
            final int arabicNumber = Integer.parseInt(arabicNumberString);
            mainView.displayResult(arabicNumber, romanNumeralConverter.convert(arabicNumber));
        } catch (final NumberFormatException e) {
            mainView.displayInvalidNumberError();
        } catch (final IllegalStateException e) {
            mainView.displayNonPositiveNumberError();
        }
    }

    @Override
    public void onResume() {
        // no-op
    }
}
