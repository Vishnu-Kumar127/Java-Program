import java.util.Scanner;

public class Question_9 
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the Size of the Array A: ");
        int size=input.nextInt();
        int[] arr=new int[size];

        System.out.println("Enter Elements: ");
        for (int i = 0; i < size; i++) 
        {
            System.out.print((i+1)+" :");
            arr[i] = input.nextInt();
        }
        
        for(int i=0;i<arr.length;i++)
        {
            for(int j=0;j<arr.length;j++)
            {
                if(arr[j] == arr[i]+1)
                {
                    System.out.print(arr[j]);
                    break;
                }
            }
            System.out.print("_");
        }
        input.close();
    }
}
