/**
 * Simple java program that calculates numerical approximation of exponential function using the Maclaurin series.
 * It stops when error is less than 0.5 %
 * Author: Jakub Szczepaniak
 * Date: 18/03/2024
 */
import java.util.Scanner;

public class Main {
    public static double factorial(int baseNum) {
        if (baseNum == 0 || baseNum == 1) {
            return 1;
        } else {
            return baseNum * factorial(baseNum - 1); // recursive call
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // create a Scanner object to read input

        System.out.print("""

                Hello and welcome!
                
                This program calculates exponential function term based on Maclaurin series expansion.
                """);
        System.out.print("Enter value of x: ");

        float x = scanner.nextFloat(); // the exponent value
        double ans = 1; // answer of Maclaurin series expansion
        int iter = 1;
        double errAbs;
        double trueValue = Math.exp(x);
        System.out.println("You entered: " + x);
        System.out.println("True value: " + trueValue);

        do {
            double oldAns = ans;
            ans = ans + Math.pow(x, iter) / factorial(iter);
            iter += 1;
            System.out.println("e^" + x + " (iteration: " + iter +") = " + ans);

            errAbs = Math.abs((ans - oldAns) / ans) * 100; // absolute error
            System.out.printf("Error: %.2f", errAbs);
            System.out.println(" % \n");


        } while (errAbs > 0.5);
        scanner.close(); // closing Scanner object
    }
}