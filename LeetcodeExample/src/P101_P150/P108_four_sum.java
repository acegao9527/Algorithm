package P101_P150;

import java.util.ArrayList;
import java.util.Arrays;

public class P108_four_sum {

	public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        int len = num.length;
        if (len<4){
            return result;
        }
        for (int i=0;i<len;i++){
            if ((i>0&&num[i] != num[i-1])||i==0){
                for (int j=i+1;j<len;j++){
                    if ((j>i+1&&num[j] != num[j-1])||j==i+1){
                        int curTar = target-num[i]-num[j];
                        int start = j+1;int end = len-1;
                        while (start<end){
                            if (num[start]+num[end]==curTar){
                                ArrayList<Integer> temp = new ArrayList<Integer>();
                                temp.add(num[i]);temp.add(num[j]);
                                temp.add(num[start]);temp.add(num[end]);
                                result.add(temp);
                                start++;end--;
                                while (start <len&&num[start]==num[start-1])start++;
                                while (end >=0&&num[end]==num[end+1])end--;
                            }
                            else if (num[start]+num[end]<curTar){
                                start++;
                                while (start <len&&num[start]==num[start-1])start++;
                            }
                            else {
                                end--;
                                while (end >=0&&num[end]==num[end+1])end--;
                            }
                        }
                    }
                }
            }
        }
        return result;
    }
}
