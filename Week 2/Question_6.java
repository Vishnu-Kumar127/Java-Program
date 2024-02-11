import java.util.Scanner;

public class Question_6 
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
        arr = quickSort(arr);

        int ans = 0;

        if (size<3) 
        {
            System.out.println("Not Possible Because the array Contains less than 3 elements");   
        }
        else if (size == 3) 
        {
            System.out.println("The Minimum Product of 3 Elements in an Array is "+(arr[0] * arr[1] * arr[2]));
        } 
        else 
        {
            int last =arr.length - 1;
            ans = Math.min(arr[0] * arr[1] * arr[2], arr[0] * arr[last - 1] * arr[last]);
            System.out.println("The Minimum Product of 3 Elements in an Array is " + ans);
        }
        input.close();
    }
    static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        int i = low;
        int j = high;

        while (i < j) {
            while (arr[i] <= pivot && i <= high - 1) {
                i++;
            }

            while (arr[j] > pivot && j >= low + 1) {
                j--;
            }
            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[low];
        arr[low] = arr[j];
        arr[j] = temp;
        return j;
    }

    static void qs(int[] arr, int low, int high) {
        if (low < high) {
            int pIndex = partition(arr, low, high);
            qs(arr, low, pIndex - 1);
            qs(arr, pIndex + 1, high);
        }
    }
    public static int[] quickSort(int[] arr) {
        qs(arr, 0, arr.length - 1);
        return arr;
    }
}
