import java.util.Scanner;

public class AddingNumbers {

        // Method to add two number strings
        public static String addNumberStrings(String num1, String num2) {
            try {
                // Convert the number strings to integers
                int number1 = Integer.parseInt(num1);
                int number2 = Integer.parseInt(num2);

                int sum = number1 + number2;

                return String.valueOf(sum);
            } catch (NumberFormatException e) {
                return "Error: Invalid input!";
            }
        }
        // Main method
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter the first number string:");
            String num1 = scanner.nextLine();

            System.out.println("Enter the second number string:");
            String num2 = scanner.nextLine();

            String result = addNumberStrings(num1, num2);
            System.out.println("The sum is: " + result);

            scanner.close();
        }
    }

