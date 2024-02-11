import java.util.Scanner;

public class Question_2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the Number of Rows : ");
        int N=input.nextInt();

        for (int row = 1; row <= N; row++) 
        {
            for (int col = 1; col <= N + row - 1; col++) 
            {
                if(col <= N-row) System.out.print(" ");
                else System.out.print("+");
            }
            System.out.println();
        }
        input.close();
    }
}
