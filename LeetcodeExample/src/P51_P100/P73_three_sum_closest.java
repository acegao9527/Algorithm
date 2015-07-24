package P51_P100;

import java.util.Arrays;

public class P73_three_sum_closest {

	public int threeSumClosest(int[] num, int target) {
        int n = num.length;
        if(n<2){
            return -1;
        }
        int check,start,end,result;
        result = num[0]+num[1]+num[2];
        Arrays.sort(num);
        for (int i=0;i<n;i++){
            check = target-num[i];
            start = i+1;
            end = n-1;
            while (start<end){
                int diff = check-(num[start]+ num[end]);
                if(diff==0){
                    return target;
                }
                else if (diff>0){
                    if(Math.abs(result-target)>diff){
                        result = num[i]+num[start]+num[end];
                    }
                    start++;
                }
                else if (diff<0){
                    if(Math.abs(result-target)>-diff){
                        result = num[i]+num[start]+num[end];
                    }
                    end--;
                }
            }
        }
        return result;
    }
}
