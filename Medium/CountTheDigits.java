import java.util.Scanner;

public class CountTheDigits {

        public static void main(String[] args) {s
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter a number: ");
            int number = scanner.nextInt();

            int digitCount = countDigits(number);
            System.out.println("The number of digits is: " + digitCount);
        }

        public static int countDigits(int num) {
            num = Math.abs(num);
            if (num == 0) {
                return 1;
            }

            int count = 0;
            while (num > 0) {
                num /= 10;
                count++;
            }

            return count;
        }
    }
