import java.util.Scanner;

/**
 * Write a  text-based program to repeatedly ask the user to enter a number. The user can enter a number <= 0 to stop.
 *
 * For each number entered by the user, create a new thread that will determine if the number is prime.
 * The thread should print the result when it completes.
 *
 * One way to test your program is to enter in two very large primes. The program should ask for the second number before it's done calculating the first. For example, 275604547 and 413158523.
 *
 * Very large primes:
 * 671998030559713968361666935769 (30 digits)
 * 1111235916285193
 *
 */
public class PrimeDriver {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double inputNumber;
        do {
            System.out.print("Please enter a number to test for primality (enter negative to exit): ");
            System.out.println();
            inputNumber = scan.nextDouble();
            Thread newThread = new Thread(new Prime(inputNumber));
            newThread.start();
        } while (inputNumber >= 0);
    }
}
