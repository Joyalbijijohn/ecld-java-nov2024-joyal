
import java.util.Scanner;

public class Calculator {

    public static int add(int a, int b) {
        return a + b;
    }

    public static int subtract(int a, int b) {
        return a - b;
    }

    public static int multiply(int a, int b) {
        return a * b;
    }

    public static String divide(int a, int b) {
        if (b == 0) {
            return "Error: Division by zero is not allowed.";
        }
        return String.valueOf((double) a / b); // Return result as a string
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        int num1 = scanner.nextInt();
        System.out.print("Enter the second number: ");
        int num2 = scanner.nextInt();

        System.out.println("Choose an operation:");
        System.out.println("1. Add (+)");
        System.out.println("2. Subtract (-)");
        System.out.println("3. Multiply (*)");
        System.out.println("4. Divide (/)");
        System.out.print("Enter the Choice :");

        int operation = scanner.nextInt();

        switch (operation) {
            case 1:
                System.out.println("The result of " + num1 + " + " + num2 + " = " + add(num1, num2));
                break;
            case 2:
                System.out.println("The result of " + num1 + " - " + num2 + " = " + subtract(num1, num2));
                break;
            case 3:
                System.out.println("The result of " + num1 + " * " + num2 + " = " + multiply(num1, num2));
                break;
            case 4:
                System.out.println("The result of " + num1 + " / " + num2 + " = " + divide(num1, num2));
                break;
            default:
                System.out.println("Invalid operation selected.");
                break;
        }

        scanner.close();
    }
}