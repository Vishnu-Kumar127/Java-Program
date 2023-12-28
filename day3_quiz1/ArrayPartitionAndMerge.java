import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArrayPartitionAndMerge 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the array elements separated by spaces: ");
        String[] inputArray = scanner.nextLine().split(" ");

        System.out.print("Enter the partition size: ");
        int partitionSize = scanner.nextInt();

        System.out.println("Enter the partition order :");
        List<Integer> partitionOrder = new ArrayList<>();
        int order_size;
        if ((inputArray.length % partitionSize) == 0) 
        {
            order_size=inputArray.length / partitionSize ;
        } 
        else
        {
            order_size = (inputArray.length / partitionSize)+1;
        }

        for (int i = 0; i < order_size; i++) 
        {
            System.out.print((i+1)+": ");
            partitionOrder.add(scanner.nextInt());
        }

        List<List<Integer>> partitions = partitionArray(inputArray, partitionSize);

        List<Integer> mergedArray = mergePartitions(partitions, partitionOrder);

        System.out.println("Output:");
        for (int num : mergedArray) 
        {
            System.out.print(num + " ");
        }

        scanner.close();
    }

    private static List<List<Integer>> partitionArray(String[] array, int partitionSize) 
    {
        List<List<Integer>> partitions = new ArrayList<>();
        for (int i = 0; i < array.length; i += partitionSize) 
        {
            List<Integer> partition = new ArrayList<>();
            for (int j = i; j < i + partitionSize && j < array.length; j++) 
            {
                partition.add(Integer.parseInt(array[j]));
            }
            partitions.add(partition);
        }
        return partitions;
    }

    private static List<Integer> mergePartitions(List<List<Integer>> partitions, List<Integer> partitionOrder) 
    {
        List<Integer> mergedArray = new ArrayList<>();
        for (int index : partitionOrder) 
        {
            if (index >= 1 && index <= partitions.size()) 
            {
                mergedArray.addAll(partitions.get(index - 1));
            }
        }
        return mergedArray;
    }
}