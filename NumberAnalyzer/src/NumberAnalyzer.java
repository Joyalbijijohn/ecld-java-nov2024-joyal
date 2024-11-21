import java.util.Scanner;

public class NumberAnalyzer {

        public static void analyzeNumber(int num) {

            if (num > 0) {
                System.out.print( num "Number"  + " is Positive, ");
            } else if (num < 0) {
                System.out.print(num + " is Negative, ");
            } else {
                System.out.print(num + " is Zero, ");
            }

            if (num % 2 == 0) {
                System.out.print("even, ");
            } else {
                System.out.print("odd, ");
            }

            if (num % 5 == 0) {
                System.out.println("and A multiple of 5.");
            } else {
                System.out.println("and Not a multiple of 5.");
            }
        }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            for (int i = 0; i < 5; i++) {
                System.out.print("Please Enter Number " + (i + 1) + ": ");
                int number = scanner.nextInt();
                analyzeNumber(number);
            }

            scanner.close();
        }
    }



