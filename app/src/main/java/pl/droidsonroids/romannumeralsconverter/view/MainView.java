package pl.droidsonroids.romannumeralsconverter.view;

public interface MainView {

    void displayResult(final int arabicNumber, final String romanResult);
    void displayInvalidNumberError();
    void displayNonPositiveNumberError();
}
