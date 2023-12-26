import java.util.Scanner;
public class compressofString
{
    public static String compressString(String input)
    {
        StringBuilder compressed = new StringBuilder();
        int count = 1;
        for (int i = 1; i < input.length(); i++)
        {
            if (input.charAt(i) == input.charAt(i - 1))
            {
                count++;
            } 
            else
            {
                compressed.append(input.charAt(i - 1));
                if (count > 1)
                {
                    compressed.append(count);
                }
                count = 1;
            }
        }
        compressed.append(input.charAt(input.length() - 1));
        if (count > 1)
        {
            compressed.append(count);
        }
        return compressed.toString();
    }
    public static void main(String[] args)
    {
        Scanner s=new Scanner(System.in);
        System.out.print("Enter String: ");
        String st=s.next();
        System.out.println("Input: " + st);
        System.out.println("Output: " + compressString(st));
        s.close();
    }
}