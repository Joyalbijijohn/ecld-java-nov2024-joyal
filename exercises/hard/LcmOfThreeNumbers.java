import java.util.Scanner;

public class LcmOfThreeNumbers {


        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter three numbers separated by spaces:");
            int num1 = scanner.nextInt();
            int num2 = scanner.nextInt();
            int num3 = scanner.nextInt();

            int lcm = findLCM(num1, num2, num3);
            System.out.println("The Least Common Multiple (LCM) of " + num1 + ", " + num2 + ", and " + num3 + " is: " + lcm);
        }

        public static int findLCM(int a, int b, int c) {
            int lcmAB = lcm(a, b);
            return lcm(lcmAB, c);
        }

        public static int lcm(int a, int b) {
            return (a * b) / gcd(a, b);
        }

        public static int gcd(int a, int b) {
            if (b == 0) {
                return a;
            }
            return gcd(b, a % b);
        }
    }


