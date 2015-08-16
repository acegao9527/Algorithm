package ExampleSolution.P1_P50;
import java.util.ArrayList;


public class P33_permutations {

	public class Solution {
	    public ArrayList<ArrayList<Integer>> permute(int[] num) {
	        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	        int n = num.length;
	        if (n == 0){
	            return result;
	        }
	        if (n == 1){
	            ArrayList<Integer> t = new ArrayList<Integer>();
	            t.add(num[0]);
	            result.add(t);
	            return result;
	        }
	        for (int i=0;i<num.length;i++){
	            int []temp = new int[num.length-1];
	            for (int j=0;j<num.length;j++){
	                if (j<i){
	                    temp[j]= num[j];
	                }
	                else if (j>i){
	                    temp[j-1]=num[j];
	                }
	            }
	            ArrayList<ArrayList<Integer>> subResult = permute(temp);
	            for (int k=0;k<subResult.size();k++){
	                ArrayList<Integer> row = new ArrayList<Integer>();
	                row.add(num[i]);
	                row.addAll(subResult.get(k));
	                result.add(row);
	            }
	        }
	        return result;
	    }
	}
}
