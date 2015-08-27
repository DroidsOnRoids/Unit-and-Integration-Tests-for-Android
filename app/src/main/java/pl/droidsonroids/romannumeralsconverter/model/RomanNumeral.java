package pl.droidsonroids.romannumeralsconverter.model;

class RomanNumeral {

    private final int arabicNumber;

    public RomanNumeral(final int arabicNumber) {
        this.arabicNumber = arabicNumber;
    }

    @Override
    public String toString() {
        if (arabicNumber <= 0) {
            throw new IllegalStateException("Cannot convert number smaller or equal to 0!");
        }

        final StringBuilder stringBuilder = new StringBuilder();

        int arabicNumberBuffer = this.arabicNumber;

        for (final Numeral numeral : Numeral.values()) {
            while (arabicNumberBuffer >= numeral.weight) {
                stringBuilder.append(numeral);
                arabicNumberBuffer -= numeral.weight;
            }
        }

        return stringBuilder.toString();
    }

    private enum Numeral {

        M(1000),
        CM(900),
        D(500),
        CD(400),
        C(100),
        XC(90),
        L(50),
        XL(40),
        X(10),
        IX(9),
        V(5),
        IV(4),
        I(1);

        private final int weight;

        Numeral(final int weight) {
            this.weight = weight;
        }
    }
}
