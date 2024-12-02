public class PerfectNo {

        public static boolean isPerfectNumber(int number) {
            if (number <= 1) {
                return false;
            }

            int sum = 0;

            for (int i = 1; i <= number / 2; i++) {
                if (number % i == 0) {
                    sum += i;
                }
            }

            return sum == number;
        }

        public static void main(String[] args) {
            System.out.println(isPerfectNumber(6));
            System.out.println(isPerfectNumber(28));
            System.out.println(isPerfectNumber(12));
            System.out.println(isPerfectNumber(496));
            System.out.println(isPerfectNumber(0));

        }
    }



