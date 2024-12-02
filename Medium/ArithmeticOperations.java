public class ArithmeticOperations {

        public static int performOperation(String num1, String num2, String operation) {
            try {

                int number1 = Integer.parseInt(num1);
                int number2 = Integer.parseInt(num2);
                if (operation.equals("add")) {
                    return number1 + number2;
                } else if (operation.equals("subtract")) {
                    return number1 - number2;
                } else if (operation.equals("multiply")) {
                    return number1 * number2;
                } else if (operation.equals("divide")) {

                    return number1 / number2;
                } else {

                    System.out.println("Invalid operation!");
                    return 0;
                }
            } catch (ArithmeticException e) {

                System.out.println("Arithmetic exception occurred: " + e.getMessage());
                return Integer.MIN_VALUE;
            } catch (NumberFormatException e) {

                System.out.println("Invalid number format: " + e.getMessage());
                return 0;
            }
        }


        public static void main(String[] args) {

            System.out.println(performOperation("10", "5", "add"));
            System.out.println(performOperation("10", "5", "subtract"));
            System.out.println(performOperation("10", "5", "multiply"));
            System.out.println(performOperation("10", "5", "divide"));
            System.out.println(performOperation("10", "0", "divide"));
            System.out.println(performOperation("10a", "5", "add"));
        }
    }



