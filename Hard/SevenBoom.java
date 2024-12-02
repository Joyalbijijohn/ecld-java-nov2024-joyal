public class SevenBoom {

        public static String SevenBoom(int[] numbers) {
            for (int number : numbers) {
                if (String.valueOf(number).contains("7")) {
                    return "Boom!";
                }
            }
            return "There is no 7 in the array";
        }

        public static void main(String[] args) {
            System.out.println(SevenBoom(new int[]{1, 2, 3, 4, 5}));
            System.out.println(SevenBoom(new int[]{6, 7, 8, 9, 10}));
            System.out.println(SevenBoom(new int[]{70, 15, 21, 37, 49}));
            System.out.println(SevenBoom(new int[]{12, 34, 56, 89}));
            System.out.println(SevenBoom(new int[]{40, 75, 56, 80, 65}));
        }
    }



