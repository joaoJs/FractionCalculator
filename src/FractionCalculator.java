import java.util.Scanner;
import  java.util.Arrays;
public class FractionCalculator {

    public static void main(String[] args) {
        //String op = getOperation();
        //System.out.println(op);
        boolean is = validFraction("67/5");
        System.out.println(is);
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
        } else if (input.indexOf("/") == -1) {
            return false;
        } else {
            String[] arr = input.split("[/]");
            System.out.println(Arrays.toString(arr));
            if (arr.length > 2) {
                return false;
            } else {
                if (isNumber(arr[0]) && isNumber(arr[1])) {
                    System.out.println(Integer.parseInt(arr[0]));
                    System.out.println(Integer.parseInt(arr[1]));
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
 }
