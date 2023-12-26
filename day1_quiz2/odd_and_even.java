import java.util.Scanner;
public class odd_and_even
{
    public static void main(String[] args)
    {
        Scanner s=new Scanner(System.in);
        System.out.print("Enter no. of elements in the Array: ");
        int n=s.nextInt();
        int arr[]=new int[n];

        System.out.println("Enter Elements: ");
        for(int i=0;i<n;i++)
        {
            System.out.print((i+1)+":");
            arr[i]=s.nextInt();
        }

        int j=0,k=0;
        int odd[]=new int[n],even[]=new int[n];

        for(int i=0;i<n;i++)
        {
            if(arr[i]%2==0)
            {
                even[j]=arr[i];
                j++;
            }
            else{
                odd[k]=arr[i];
                k++;
            }
        }
        
        System.out.print("Odd Numbers: ");
        for(int i=0;i<k;i++)
        {
            System.out.print(odd[i]+" ");
        }
        System.out.println();

        System.out.print("Even Numbers: ");
        for(int i=0;i<j;i++)
        {
            System.out.print(even[i]+" ");
        }
        System.out.println();

        s.close();
    }
}