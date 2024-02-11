import java.util.Scanner;

public class Question_10 
{
    public static void main(String[] args)
     {
         Scanner input = new Scanner(System.in);

        System.out.println("Enter a string:");
        input.nextLine();
        String word = input.nextLine();
         System.out.println("reversal:"+rev(word));
        input.close();
     }
     
     static String rev(String s)
     {
         char[] ch = s.toCharArray();
         int start = 0;
         int end = ch.length - 1;
         
         char[] ans = new char[end+1];
         
         while(start<=end)
         {
             if(((ch[start]>=65 && ch[start]<=91) || (ch[start]>=97 && ch[start]<=123) || (ch[start]>=48 && ch[start]<=57)) && ((ch[end]>=65 && ch[end]<=91) || (ch[end]>=97 && ch[end]<=123) || (ch[end]>=48 && ch[end]<=57)))
             {
                 ans[start] = ch[end];
                 ans[end] = ch[start];
                 start++;
                 end--;
             }
             else if((ch[start]>=65 && ch[start]<=91) || (ch[start]>=97 && ch[start]<=123) || (ch[start]>=48 && ch[start]<=57))
             {
                 ans[end] = ch[end];
                 end --;
             }
             else
             {
                 ans[start] = ch[start];
                 start++;
             }
         }
         return ans.toString();
         
     }
}
