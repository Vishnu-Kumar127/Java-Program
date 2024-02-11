import java.util.Scanner;

public class Question_8 
{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the first string:");
        input.nextLine();
        String str1 = input.nextLine();

        System.out.println("Enter the second string:");
        input.nextLine();
        String str2 = input.nextLine();

        int len1 = str1.length();
        int len2 = str2.length();
        char[] ans = new char[len1 + len2];
        int start = 0, end = 0;
        for (int i = 0; i < len1; i++) {
            ans[i] = str1.charAt(i);
        }
        if (ans[len1 - 1] == str2.charAt(0)) {
            start = len1;
            end = len1 + len2;
        } else {
            ans[len1] = str2.charAt(0);
            start = len1;
            end = len1 + len2;
        }
        for (int i = start + 1; i < end; i++) {
            ans[i] = str2.charAt(i - start);
        }
        System.out.println("Concatenated string: " + new String(ans));
        input.close();
    }
}
