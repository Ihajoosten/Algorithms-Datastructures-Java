import java.util.Scanner;

public class ComputeFactorialRecursive {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter a non-negative number: ");
        int input = reader.nextInt();

        System.out.println("Factorial of number " + input + " is " + factorialRecursive(input));
    }

    public static int factorialRecursive(int n) {
        if (n == 0) return 1;
        else return n * factorialRecursive(n -1);
    }
}
