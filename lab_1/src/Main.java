import java.util.Scanner;

public class Main {
    public static double factorial(int baseNum) {
        if (baseNum == 0 || baseNum == 1) {
            return 1;
        } else {
            return baseNum * factorial(baseNum - 1);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // create a Scanner object to read input

        System.out.print("""

                "Hello and welcome!"
                
                This program calculates exponential function term based on Maclaurin series expansion.
                """);
        System.out.print("Enter value of x: ");

        float x = scanner.nextFloat();
        double ans = 1;
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

            errAbs = Math.abs((ans - oldAns) / ans) * 100;

        } while (errAbs > 1);
        scanner.close(); // closing Scanner object
    }
}