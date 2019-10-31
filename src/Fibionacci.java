import java.util.Scanner;

public class Fibionacci {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an index for a Fibonacci number: ");
        int index = input.nextInt();

        // Find and display the Fibonacci number
        System.out.println("The Fibonacci number at index " + index + " is " + fibonacciLoop(index));
//        System.out.println("The Fibonacci number at index " + index + " is " + fib(index));
    }

    // Recursive
    public static int fib(int n) {
        if (n <= 1) return 1;
            // return the sum of the previous int & the previous-previous int
        else return fib(n - 1) + fib(n - 2);
    }

    // Iterative
    public static int fibonacciLoop(int nthNumber) {
        int previouspreviousNumber;
        int previousNumber = 1;
        int currentNumber = 1;

        for (int i = 1; i < nthNumber; i++) {
            previouspreviousNumber = previousNumber;
            previousNumber = currentNumber;
            currentNumber = previouspreviousNumber + previousNumber;
        }
        return currentNumber;
    }
}
