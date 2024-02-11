import java.util.Scanner;

public class Question_3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the Size of the Array A: ");
        int size_A=input.nextInt();
        int[] array_a=new int[size_A];

        System.out.println("Enter Elements: ");
        for (int i = 0; i < size_A; i++) 
        {
            System.out.print((i+1)+" :");
            array_a[i] = input.nextInt();
        }
        System.out.print("Enter the Size of the Array B: ");
        int size_B=input.nextInt();

        int[] array_b=new int[size_B];
        System.out.println("Enter Elements: ");
        for (int i = 0; i < size_B; i++) 
        {
            System.out.print((i+1)+" :");
            array_b[i] = input.nextInt();
        }
        System.out.print("Array A Elements: ");

        for (int Elements : array_a) 
        {
            System.out.print(Elements+ " ");    
        }
        System.out.println();
        System.out.print("Array B Elements: ");

        for (int Elements : array_b) 
        {
            System.out.print(Elements+ " ");    
        }
        System.out.println();
        substraction(array_a,array_b);
        input.close();
    }

    private static void substraction(int[] array_a, int[] array_b) 
    {
        int a=0,b=0;

        for (int Elements : array_a) 
        {
            a = (a * 10) + Elements;
        }

        for (int Elements : array_b) 
        {
            b = (b * 10) + Elements;
        }

        a = (int)Math.abs(a - b);

        int[] array_c = new int[Math.max(array_a.length, array_b.length)];

        for (int i =  array_c.length - 1; i >= 0; i--) 
        {
            array_c[i] = a %10;
            a /= 10;
        }

        System.out.print("The Difference Between 2 array is: ");

        for (int Elements : array_c) 
        {
            System.out.print(Elements+ " ");    
        }
    }
}
