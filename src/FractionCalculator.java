import java.util.Scanner;
public class FractionCalculator {

    public static void main(String[] args) {
        String op = getOperation();
        System.out.println(op);
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
}
