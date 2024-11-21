import java.util.Scanner;

    public class TemperatureConverter {

        public static double celsiusToFahrenheit(double celsius) {
            return (celsius * 9/5) + 32;
        }

        public static double fahrenheitToCelsius(double fahrenheit) {
            return (fahrenheit - 32) * 5/9;
        }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int choice;

            do {
                System.out.println("Temperature Converter");
                System.out.println("1. Convert Celsius to Fahrenheit");
                System.out.println("2. Convert Fahrenheit to Celsius");
                System.out.println("3. Exit");
                System.out.print("Choose Option: ");
                choice = scanner.nextInt();

                if (choice == 1) {
                    System.out.print("Enter temperature in Celsius: ");
                    double celsius = scanner.nextDouble();
                    double fahrenheit = celsiusToFahrenheit(celsius);
                    System.out.printf("Temperature in Fahrenheit: %.1f°F%n", fahrenheit);
                } else if (choice == 2) {
                    System.out.print("Enter temperature in Fahrenheit: ");
                    double fahrenheit = scanner.nextDouble();
                    double celsius = fahrenheitToCelsius(fahrenheit);
                    System.out.printf("Temperature in Celsius: %.1f°C%n", celsius);
                } else if (choice != 3) {
                    System.out.println("Invalid choice. Please try again.");
                }

            } while (choice != 3);

            System.out.println("Exit.");
            scanner.close();
        }
    }



