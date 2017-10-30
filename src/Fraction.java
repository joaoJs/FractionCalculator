public class Fraction {
    private int numerator;
    private int denominator;

    public static void main(String[] args) {
        Fraction first = new Fraction(4,1);
        Fraction second = new Fraction(3,2);
        first.subtract(second);
    }

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

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public String toString() {
        return numerator + "/" + denominator;
    }

    public double toDouble() {
        return (double)(numerator / denominator);
    }

    public Fraction add(Fraction other) {
        int num = 0;
        int den = 1;
        if (this.denominator == other.denominator) {
            num = this.numerator + other.numerator;
            den = this.denominator;
        } else if (this.denominator < other.denominator) {
            int cons = this.denominator;
            while (this.denominator % other.denominator != 0) {
                this.denominator += cons;
            }
            num = (this.numerator * this.denominator / cons) + (other.numerator * this.denominator / other.denominator);
            den = this.denominator;
        } else if (this.denominator > other.denominator) {
            int cons = other.denominator;
            while (other.denominator % this.denominator != 0) {
                other.denominator += cons;
            }
            num = (this.numerator * other.denominator / this.denominator) + (other.numerator * other.denominator / cons);
            den = other.denominator;
        }
        Fraction addedFraction = new Fraction(num, den);
        System.out.println("Here --> " + addedFraction.toString());
        return addedFraction;
    }

    public Fraction subtract(Fraction other) {
        int num = 0;
        int den = 1;
        if (this.denominator == other.denominator) {
            num = this.numerator + other.numerator;
            den = this.denominator;
        } else if (this.denominator < other.denominator) {
            int cons = this.denominator;
            while (this.denominator % other.denominator != 0) {
                this.denominator += cons;
            }
            num = (this.numerator * this.denominator / cons) - (other.numerator * this.denominator / other.denominator);
            den = this.denominator;
        } else if (this.denominator > other.denominator) {
            int cons = other.denominator;
            while (other.denominator % this.denominator != 0) {
                other.denominator += cons;
            }
            num = (this.numerator * other.denominator / this.denominator) - (other.numerator * other.denominator / cons);
            den = other.denominator;
        }
        Fraction subtractedFraction = new Fraction(num, den);
        System.out.println("Here --> " + subtractedFraction.toString());
        return subtractedFraction;
    }
//
//    public double multiply(Fraction other) {
//
//    }
//
//    public double divide(Fraction other) {
//
//    }

}
