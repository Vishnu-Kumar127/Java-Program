import java.util.Scanner;

public class Question_4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the Number: ");
        int num = input.nextInt();

        int[] nums = new int[(int)Math.log10(num) + 1];
        for (int i =  nums.length - 1; i >= 0; i--) 
        {
            nums[i] = num %10;
            num /= 10;
        }
        

        if (canPartition(nums.length, nums))
            System.out.println("It's a cool Number");
        else
            System.out.println("It's not a cool Number");
        input.close();
    }

    static boolean canPartition(int n, int[] arr) 
    {
        int totSum = 0;
        for (int i = 0; i < n; i++) {
            totSum += arr[i];
        }

        if (totSum % 2 == 1)
            return false;
        else {
            int k = totSum / 2;
            boolean prev[] = new boolean[k + 1];

            // Initialize the first row of the DP table
            prev[0] = true;

            if (arr[0] <= k) {
                prev[arr[0]] = true;
            }

            for (int ind = 1; ind < n; ind++) {
                boolean cur[] = new boolean[k + 1];
                cur[0] = true;
                for (int target = 1; target <= k; target++) {
                    boolean notTaken = prev[target];

                    boolean taken = false;
                    if (arr[ind] <= target) {
                        taken = prev[target - arr[ind]];
                    }

                    cur[target] = notTaken || taken;
                }
                prev = cur;
            }

            return prev[k];
        }
    }
}
