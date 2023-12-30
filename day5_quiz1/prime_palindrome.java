import java.util.Scanner;

class PrimeNumberThread extends Thread {
    private int start;
    private int end;

    public PrimeNumberThread(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public void run() {
        System.out.println("Prime numbers from " + start + " to " + end + ": " + findPrimes(start, end));
    }

    private String findPrimes(int start, int end) {
        StringBuilder result = new StringBuilder();
        for (int i = start; i <= end; i++) {
            if (isPrime(i)) {
                result.append(i).append(" ");
            }
        }
        return result.toString();
    }

    private boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}

class PalindromeNumberThread extends Thread {
    private int start;
    private int end;

    public PalindromeNumberThread(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public void run() {
        System.out.println("Palindrome numbers from " + start + " to " + end + ": " + findPalindromes(start, end));
    }

    private String findPalindromes(int start, int end) {
        StringBuilder result = new StringBuilder();
        for (int i = start; i <= end; i++) {
            if (isPalindrome(i)) {
                result.append(i).append(" ");
            }
        }
        return result.toString();
    }

    private boolean isPalindrome(int num) {
        int originalNum = num;
        int reversedNum = 0;

        while (num > 0) {
            int digit = num % 10;
            reversedNum = reversedNum * 10 + digit;
            num /= 10;
        }

        return originalNum == reversedNum;
    }
}

public class prime_palindrome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the start range for prime numbers: ");
        int primeStart = scanner.nextInt();

        System.out.print("Enter the end range for prime numbers: ");
        int primeEnd = scanner.nextInt();

        System.out.print("Enter the start range for palindrome numbers: ");
        int palindromeStart = scanner.nextInt();

        System.out.print("Enter the end range for palindrome numbers: ");
        int palindromeEnd = scanner.nextInt();

        PrimeNumberThread primeThread = new PrimeNumberThread(primeStart, primeEnd);
        PalindromeNumberThread palindromeThread = new PalindromeNumberThread(palindromeStart, palindromeEnd);

        // Start the prime thread
        primeThread.start();
        try {
            primeThread.join(); // Wait for the prime thread to finish
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Start the palindrome thread
        palindromeThread.start();

        // Close the scanner
        scanner.close();
    }
}
