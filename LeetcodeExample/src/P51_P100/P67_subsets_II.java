package P51_P100;

import java.util.ArrayList;
import java.util.Arrays;

public class P67_subsets_II {

	public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        if (num.length==0){
            return new ArrayList<ArrayList<Integer>>();
        }
        Arrays.sort(num);
        int index = 0;
        int SwithTime[][] = new int[num.length][2];
        SwithTime[0][0] = 1;
        SwithTime[0][1] = num[0];
        for (int i=1;i<num.length;i++){
            if(num[i-1]!=num[i]){
                index++;
                SwithTime[index][0] = 1;
                SwithTime[index][1] = num[i];
            }
            else {
                SwithTime[index][0]++;
            }
        }
        return generateSubset(SwithTime,index);
    }
    public ArrayList<ArrayList<Integer>> generateSubset(int[][] S,int length) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (length == 0){
            ArrayList<Integer> t1 = new ArrayList<Integer>();
            result.add(t1);
            ArrayList<Integer> t2 = new ArrayList<Integer>();
            for (int i = 0;i<S[length][0];i++){
                t2.add(S[length][1]);
                result.add(new ArrayList<Integer>(t2));
            }
        }
        else {
            result = generateSubset(S,length-1);
            int k = result.size();
            for(int i=0;i<k;i++) {
                ArrayList<Integer> temp = new ArrayList<Integer>();
                temp.addAll(result.get(i));
                for (int j = 0;j<S[length][0];j++){
                    temp.add(S[length][1]);
                    result.add(new ArrayList<Integer>(temp));
                }
            }
        }
        return result;
    }
}
