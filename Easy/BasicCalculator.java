public class Main {

        public static double calculate(double num1, double num2, char operator) {
           switch  (operator) {
                 case '+':
                    return num1 + num2;
                case '-':
                    return num1 - num2;
                case '*':
                    return num1 * num2;
                case '/':

                    if (num2 == 0) {
                        return 0;
                    }
                    return num1 / num2;
                default:

                    System.out.println("Invalid operator!");
                    return 0;
            }
        }


        public static void main(String[] args) {

            System.out.println(calculate(10, 5, '+'));
            System.out.println(calculate(10, 5, '-'));
            System.out.println(calculate(10, 5, '*'));
            System.out.println(calculate(10, 5, '/'));
            System.out.println(calculate(10, 0, '/'));
            System.out.println(calculate(10, 5, '^'));
        }
    }


