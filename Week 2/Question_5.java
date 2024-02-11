import java.util.ArrayList;
import java.util.List;

public class Question_5 
{
    public static void main(String[] args) {
       
        List<List<Integer>> outerList = new ArrayList<>();
        List<Integer> innerList = new ArrayList<>();
        int arr[] = {10,20,30,40};
        int avg = 0;
        for(int i : arr){
            avg+=i;
        }
        avg = avg/arr.length;
        f(outerList,innerList,arr,arr.length-1,avg);
        System.out.println(outerList);
        
    }
    static void f(List<List<Integer>> outerList,List<Integer> innerList,int[] arr,int i,int avg){
        if(i==-1){
            if(innerList.size() > 0 && sum(innerList) == avg * innerList.size()){
                outerList.add(new ArrayList(innerList));
                
            }
            return;
        }
        f(outerList,innerList,arr,i-1,avg);
        innerList.add(arr[i]);
        f(outerList,innerList,arr,i-1,avg);
        innerList.remove(innerList.size()-1);
    }
    
    static int sum(List<Integer> innerList){
        int sum = 0;
        for(int i : innerList){
            sum += i;     
        }
        return sum;
    }

}
