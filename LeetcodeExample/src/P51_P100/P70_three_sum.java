package P51_P100;

import java.util.ArrayList;
import java.util.Arrays;


public class P70_three_sum {

	public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (num.length<3){
            return result;
        }
        Arrays.sort(num);
        int len = num.length;
        for (int i = 0;i<len-1;i++){
            int target = -num[i];
            int start = i+1, end = len-1;
            while (start<end){
                if(num[start]+num[end]==target){
                    ArrayList<Integer> temp = new ArrayList<Integer>();
                    temp.add(num[i]);
                    temp.add(num[start]);
                    temp.add(num[end]);
                    result.add(temp);
                    start++;end--;
                    while(start<end&&num[start]==num[start-1]) start++;
                    while(start<end&&num[end]==num[end+1]) end--;
                }
                else if(num[start]+num[end]>target){
                    end--;
                }
                else{
                    start++;
                }
            }
            while(i<len-1&&num[i]==num[i+1]) i++;
        }
        return result;
    }
}
