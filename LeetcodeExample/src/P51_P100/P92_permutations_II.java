package P51_P100;

import java.util.ArrayList;
import java.util.Arrays;

public class P92_permutations_II {

	public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (num.length ==0) {
            return result;
        }
        ArrayList<Integer> temp = new ArrayList<Integer>();
        Arrays.sort(num);
        generateUnique(result,temp,num,0);
        return result;
    }
    public void generateUnique(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> temp, int[] num, int count){
        if(count == num.length){
            result.add(new ArrayList<Integer>(temp));
        }
        else if(count <num.length) {
            int lastNum = num[count];
            for (int i = count;i<num.length;i++){
                if (i==count) {
                    temp.add(num[count]);
                    generateUnique(result,temp,num,count+1);
                    temp.remove(temp.size()-1);
                }
                else {
                    if (num[i] != lastNum) {
                        lastNum = num[i];
                        temp.add(num[i]);
                        
                        num[count] += num[i];
                        num[i] = num[count]- num[i];
                        num[count] -= num[i];
                        int[] tempA;
                        tempA = num.clone();
                        Arrays.sort(tempA,count+1,num.length);
                        generateUnique(result,temp,tempA,count+1);
                        temp.remove(temp.size()-1);
                        num[count] += num[i];
                        num[i] = num[count]- num[i];
                        num[count] -= num[i];
                    }
                }
            }
        }
    }
}
