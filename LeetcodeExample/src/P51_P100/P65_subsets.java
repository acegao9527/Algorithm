package P51_P100;

import java.util.ArrayList;
import java.util.Arrays;

public class P65_subsets {

	public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        if (S.length==0){
            return new ArrayList<ArrayList<Integer>>();
        }
        Arrays.sort(S);
        return generateSubset(S,S.length);
    }
    public ArrayList<ArrayList<Integer>> generateSubset(int[] S,int length) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (length == 1){
            ArrayList<Integer> t1 = new ArrayList<Integer>();
            ArrayList<Integer> t2 = new ArrayList<Integer>();
            t2.add(S[length-1]);
            result.add(t1);
            result.add(t2);
        }
        else {
            result = generateSubset(S,length-1);
            int k = result.size();
            for(int i=0;i<k;i++) {
                ArrayList<Integer> temp = new ArrayList<Integer>();
                temp.addAll(result.get(i));
                temp.add(S[length-1]);
                result.add(temp);
            }
        }
        return result;
        
    }
}
