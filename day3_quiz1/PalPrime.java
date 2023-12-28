import java.util.Scanner;

public class PalPrime 
{
    public PalPrime(int number) 
    {
        String message = generateMessage(number);
        System.out.println(message);
    }

    private String generateMessage(int number) 
    {
        String message = "Number " + number + " is ";
        
        if (isPrime(number) && isPalindrome(number)) 
        {
            message += "PalPrime";
        } 
        else if (isPrime(number)) 
        {
            message += "Prime";
        } 
        else if (isPalindrome(number)) 
        {
            message += "Palindrome";
        } 
        else 
        {
            message += "neither Prime nor Palindrome";
        }

        return message;
    }

    private boolean isPrime(int number) 
    {
        if (number <= 1) 
        {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) 
        {
            if (number % i == 0) 
            {
                return false;
            }
        }
        return true;
    }

    private boolean isPalindrome(int number) 
    {
        int original = number;
        int reversed = 0;

        while (number > 0) 
        {
            int digit = number % 10;
            reversed = reversed * 10 + digit;
            number /= 10;
        }

        return original == reversed;
    }

    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();

        int[] numbers = new int[n];
        System.out.println("Enter the positive integers: ");

        for (int i = 0; i < n; i++)
        {
            System.out.print((i+1)+": ");
            numbers[i] = scanner.nextInt();
        }

        System.out.println("\nMessages:");

        for (int number : numbers) 
        {
            new PalPrime(number);
        }

        scanner.close();
    }
}