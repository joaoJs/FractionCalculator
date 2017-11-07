import java.util.Arrays;
import java.util.Scanner;

public class FractionCalculatorAdvanced {

    public static void main(String[] args) {
        greeting();
        String operation = getOperation();
        while (!operation.equals("Q")) {
            getResult(operation);
            operation = getOperation();
        }
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

    public static String getOperation() {
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter an operation (or q to quit): ");
        String operation = input.nextLine();
        if ("qQ".contains(operation)) {
            return "Q";
        } else {
            String[] splitArray = operation.split("\\s+");
            while (splitArray.length != 3 || !validFraction(splitArray[0]) || !validFraction(splitArray[2]) || !"+-/*".contains(splitArray[1])) {
                System.out.println("Invalid operation. Must be [FRAC] [OPERATION] [FRAC]");
                System.out.print("Please enter an operation (or q to quit): ");
                operation = input.nextLine();
                if ("qQ".contains(operation)) {
                    return "Q";
                } else {
                    splitArray = operation.split("\\s+");
                }
            }
            if ("qQ".contains(operation)) {
                return "Q";
            }
            return operation;
        }
    }

    public static void getResult(String operation) {
            String[] splitArray = operation.split("\\s+");

            String[] arr1 = splitArray[0].split("[/]");
            int num1 = Integer.parseInt(arr1[0]);
            int den1 = Integer.parseInt(arr1[1]);
            Fraction f1 = new Fraction(num1, den1);

            String[] arr2 = splitArray[2].split("[/]");
            int num2 = Integer.parseInt(arr2[0]);
            int den2 = Integer.parseInt(arr2[1]);
            Fraction f2 = new Fraction(num2, den2);

            String op = splitArray[1];

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
            System.out.println("Result --> ");
            System.out.println(result);
            System.out.print("Please enter an operation (or q to quit)");
    }


    public static void greeting() {
        System.out.println("Hello, this is a fraction calculator. It will add, subtract, multiply and divide fractions until you press Q to quit.");
        System.out.println(("Valid operations are in the form [FRAC] [OPERATION] [FRAC]"));
    }
}
