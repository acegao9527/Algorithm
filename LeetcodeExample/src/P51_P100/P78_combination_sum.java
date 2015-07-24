package P51_P100;

import java.util.ArrayList;
import java.util.Collections;

public class P78_combination_sum {

	public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        int len = candidates.length;
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        for (int i=len-1;i>=0;i--){
            if (candidates[i]<=target){
                ArrayList<Integer> temp = new ArrayList<Integer>();
                generateCombination(result, temp, candidates, target,i);
                break;
            }
        }
        return result;
    }
    public void generateCombination(ArrayList<ArrayList<Integer>> result,
                                    ArrayList<Integer> temp, int[] candidates, 
                                    int target, int maxIndex) {
        if(candidates[maxIndex]==target){
            temp.add(candidates[maxIndex]);
            ArrayList<Integer> nResult = new ArrayList<Integer>(temp);
            Collections.sort(nResult);
            result.add(nResult);
            temp.remove(temp.size()-1);
        }
        else if(candidates[maxIndex]<target) {
            temp.add(candidates[maxIndex]);
            generateCombination(result, temp, candidates, target-candidates[maxIndex],maxIndex);
            temp.remove(temp.size()-1);
        }
        if (maxIndex >0)
            generateCombination(result, temp, candidates, target,maxIndex-1);
    }
}
