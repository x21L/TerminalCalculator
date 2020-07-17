import java.util.Scanner;

public class Calculator {

    private static int x, y;
    private static double a, b;
    private static String input;
    private static final Scanner scanner = new Scanner(System.in);

    private static void setNumbersFloat() {
        System.out.println("Type in the first number: ");
        input = scanner.nextLine();
        a = Double.parseDouble(input);

        System.out.println("Type in the second number: ");
        input = scanner.nextLine();
        b = Double.parseDouble(input);
    }

    private static void setNumbersInt() {
        System.out.println("Type in the first number: ");
        input = scanner.nextLine();
        x = Integer.parseInt(input);
        System.out.println("x = " + x);
        System.out.println("Type in the second number: ");
        input = scanner.nextLine();
        y = Integer.parseInt(input);
        System.out.println("y = " + y);
    }

    private static int calcOperations() {
        System.out.println("""
                You can make the following calculations:
                1.   addition
                2.   subtraction
                3.   divide
                4.   modulo
                5.   pythagoras you can calculate the hypotenuse c
                                  
                To select a calculation please press the corresponding number. 
                """);
        int operation = Integer.parseInt(scanner.nextLine());
        if (operation < 1 || operation > 5) {
            System.out.println("Wrong number please try again");
            calcOperations();
        }
        return operation;
    }

    private static void calcOperationsInt(int operation) {
        int result = 0;
        switch (operation) {
            case 1: result = additionInt();
                break;
            case 2: result = subtractionInt();
                break;
            case 3: result = divideInt();
                break;
            case 4: result = moduloInt();
                break;
            case 5: result = pythagorasInt();
                break;
            default:
                System.out.println("Something went wrong please try again");
        }
        System.out.println("The solution is = " + result);
    }

    private static void calcOperationsDouble(int operation) {
        double result = 0;
        switch (operation) {
            case 1: result = additionDouble();
                break;
            case 2: result = subtractionDouble();
                break;
            case 3: result = divideDouble();
                break;
            case 4: result = moduloDouble();
                break;
            case 5: result = pythagorasDouble();
                break;
            default:
                System.out.println("Something went wrong please try again");
        }
        System.out.println("The solution is = " + result);
    }

    /*
        calc methods
     */
    private static int additionInt() {
        System.out.println("Calculating " + x +" + " + y);
        return x + y;
    }

    private static int subtractionInt() {
        System.out.println("Calculating " + x + " - " + y);
        return x - y;
    }

    private static int divideInt() {
        System.out.println("Calculating " + x + " / " + y);
        return x / y;
    }

    private static int moduloInt() {
        System.out.println("Calculating " + x + " % " + y);
        return x % y;
    }

    private static int pythagorasInt() {
        System.out.println("Calculating c = " + "sqrt(" + x +"^2 + " + y +"^2)");
        return (int) Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }

    /*
        Now everything with doubles
     */

    private static double additionDouble() {
        System.out.println("Calculating " + a + " + " + b);
        return a + b;
    }

    private static double subtractionDouble() {
        System.out.println("Calculating " + a + " - " + b);
        return a -b;
    }

    private static double divideDouble() {
        System.out.println("Calculating " + a + " / " + b);
        return a / b;
    }

    private static double moduloDouble() {
        System.out.println("Calculating " + a + " % " + b);
        return a % b;
    }

    private static double pythagorasDouble() {
        System.out.println("Calculating c = " + "sqrt(" + a +"^2 + " + b +"^2)");
        return Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
    }



    public static void main(String[] args) {
        boolean terminate = false;
        do {
            System.out.println("""
                    Would you like to make floating point calculations?
                    type y for yes and anything else for integer calculations
                    """);
            input = scanner.nextLine();
            if (input.equals("y")) {
                setNumbersFloat();
                calcOperationsDouble(calcOperations());
            } else {
                setNumbersInt();
                calcOperationsInt(calcOperations());
            }

            System.out.println("""
                    Would you like to calculate again? 
                    Press y for yes or any other key for abort.
                    """);
            input = scanner.nextLine();
            if (!input.equals("y")) {
                terminate = true;
            }
        } while (!terminate);

        System.out.println("Thank you for using the calculator. See you soon!");
    }
}
