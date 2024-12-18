import java.util.Scanner;

public class ReverseAString {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter a string to reverse: ");
            String input = scanner.nextLine();

            String reversed = reverseString(input);
            System.out.println("Reversed string: " + reversed);
        }

        // Recursive function to reverse a string
        public static String reverseString(String str) {

            if (str.length() <= 1) {
                return str;
            }

            return reverseString(str.substring(1)) + str.charAt(0);
        }
    }

