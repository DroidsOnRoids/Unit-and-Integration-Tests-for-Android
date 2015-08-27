package pl.droidsonroids.romannumeralsconverter.model;

public class RomanNumeralConverter {

    public String convert(final int arabicNumber) {
        return new RomanNumeral(arabicNumber).toString();
    }
}
