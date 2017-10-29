public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int num, int den) {
        if (den == 0) {
            throw new IllegalArgumentException();
        } else if (den < 0) {
            den = den * -1;
            num = num * -1;
        }
        numerator = num;
        denominator = den;
    }

    public Fraction(int num) {
        this(num, 1);
    }

    public Fraction() {
        this(0, 1);
    }

}
