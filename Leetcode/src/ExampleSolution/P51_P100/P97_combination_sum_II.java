package ExampleSolution.P51_P100;

import java.util.ArrayList;
import java.util.Arrays;

public class P97_combination_sum_II {

	public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        Arrays.sort(num);
        generateComb2(result,list,num,target,num.length-1);
        return result;
    }
    public void generateComb2(ArrayList<ArrayList<Integer>> result,ArrayList<Integer> list,int[] num,int target,int index){
        if (target == 0){
            ArrayList<Integer> temp = new ArrayList<Integer>();
            for (int i = list.size()-1;i>=0;i--){
                temp.add(list.get(i));
            }
            result.add(temp);
            return;
        }
        else {
            for (int i = index;i>=0;i--){
                if (num[i]<=target&&(i==index||num[i]!=num[i+1])){
                    list.add(num[i]);
                    generateComb2(result,list,num,target-num[i],i-1);
                    list.remove(list.size()-1);
                }
            }
        }
    }
}
