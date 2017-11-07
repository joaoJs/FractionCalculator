public class Fraction {
    private int numerator;
    private int denominator;

//    public static void main(String[] args) {
//        Fraction first = new Fraction(4,4);
//        Fraction second = new Fraction(4,2);
//        boolean is = first.equals(second);
//        System.out.print(is);
//    }

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
        addedFraction.toLowestTerms();
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
        if (num == 0) {
            Fraction zero = new Fraction(0, 1);
            return zero;
        } else {
            Fraction subtractedFraction = new Fraction(num, den);
            subtractedFraction.toLowestTerms();
            return subtractedFraction;
        }
    }

    public Fraction multiply(Fraction other) {
        int num = this.numerator * other.numerator;
        int den = this.denominator * other.denominator;
        Fraction multipliedFraction = new Fraction(num, den);
        multipliedFraction.toLowestTerms();
        return multipliedFraction;
    }

    public Fraction divide(Fraction other) {
        int num = this.numerator * other.denominator;
        int den = this.denominator * other.numerator;
        Fraction dividedFraction = new Fraction(num, den);
        dividedFraction.toLowestTerms();
        return dividedFraction;
    }

    public boolean equals(Fraction other) {
        if (!(other instanceof Fraction)) {
            return false;
        } else {
            this.toLowestTerms();
            other.toLowestTerms();
            return this.toString().equals(other.toString());
        }
    }

    public void toLowestTerms() {
        int gcd = gcd(this.numerator, this.denominator);
        this.numerator = this.numerator / gcd;
        this.denominator = this.denominator / gcd;
    }

    public static int gcd(int num, int den) {
        while (num != 0 && den != 0) {
            int rem = num % den;
            num = den;
            den = rem;
        }
        return num;
    }
}
