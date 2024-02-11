import java.util.Scanner;

public class Question_1 
{
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the Number to Find Sum of the Digits: ");
        int nums = input.nextInt();
        int duplicate =nums;
        int sum=0;
        while (duplicate > 0) 
        {
               sum += duplicate % 10;
               duplicate /= 10;
        }
        System.out.println("Sum of the Digits "+nums+" = "+sum);
        input.close();
    }
}