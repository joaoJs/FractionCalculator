import java.util.Scanner;
import  java.util.Arrays;
public class FractionCalculator {

    public static void main(String[] args) {
        greeting();
        String op = getOperation();
        while (!(op.toUpperCase().equals("Q"))) {
            Fraction f1 = getFraction();
            Fraction f2 = getFraction();
            Fraction result = new Fraction();
            if (op.equals("+")) {
                result = f1.add(f2);
            } else if (op.equals("-")) {
                result = f1.subtract(f2);
            } else if (op.equals("/")) {
                result = f1.divide(f2);
            } else if (op.equals("*")) {
                result = f1.multiply(f2);
            }
            System.out.println(result);
            op = getOperation();
        }
    }

    public static String getOperation() {
        Scanner input = new Scanner(System.in);
        System.out.print("Please, enter an operation (+, -, /, *, =, or q or Q to quit): ");
        String operation = input.next();
        while ("+-/*=qQ".indexOf(operation) == -1) {
            System.out.print("Please, enter an operation (+, -, /, *, =, or q or Q to quit): ");
            operation = input.next();
        }
        return operation;
    }

    public static boolean validFraction(String input) {
        if (input.indexOf("-") > 0) {
            return false;
        } else if (input.indexOf("/") == -1 || input.charAt(input.length() - 1) == '/') {
            return false;
        } else {
            String[] arr = input.split("[/]");
            if (arr.length > 2) {
                return false;
            } else {
                if (isNumber(arr[0]) && isNumber(arr[1])) {
                    if (Integer.parseInt(arr[1]) == 0) {
                        return false;
                    } else {
                        return true;
                    }
                } else {
                    return false;
                }
            }

        }
    }

    private static boolean  isNumber(String input) {
        for (int i = 0; i < input.length(); i++) {
            if ("0123456789-".indexOf(input.charAt(i)) == -1) {
                return false;
            }
        }
        return true;
    }

    public static Fraction getFraction() {
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter (a/b), where a and b are integers and b is not less than 1: ");
        String fraction = input.next();
        while (!(validFraction(fraction))) {
            System.out.print("Please enter (a/b), where a and b are integers and b is not less than 1: ");
            fraction = input.next();
        }
        String[] arr = fraction.split("[/]");
        int num = Integer.parseInt(arr[0]);
        int den = Integer.parseInt(arr[1]);
        Fraction newFraction = new Fraction(num, den);
        return newFraction;
    }

    public static void greeting() {
        System.out.println("Hello, this is a fraction calculator. It will add, subtract, multiply and divide fractions until you press Q to quit.");
    }

 }
