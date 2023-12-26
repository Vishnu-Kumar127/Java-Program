import java.util.Scanner;
public class zig_zag 
{
    public static void printVerticalPattern(String input) 
    {
        int length = input.length();
        int n = (length+2)/3;
        System.out.println(n);
        for(int i=0;i<n;i++)
        {
            System.out.print(input.charAt(i));
        }
        System.out.println();
        for(int j=0;j<n-2;j++)
        {
            int space = n-j-2;
            for(int k=0;k<space;k++)
            {
                System.out.print(" ");
            }
            System.out.print(input.charAt(n+j));
            System.out.println();
        }
        for(int x=0;x<n;x++)
        {
            System.out.print(input.charAt(2*n+x-2));
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.next();
        printVerticalPattern(input);
        in.close();
    }
}