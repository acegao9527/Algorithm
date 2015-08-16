package ExampleSolution.P51_P100;

import java.util.HashMap;

public class P68_longest_consecutive_sequence {

	public int longestConsecutive(int[] num) {
        int n = num.length;
        if (n<=1){
            return n;
        }
        HashMap<Integer,Integer> checkBox = new HashMap<Integer,Integer>();
        for (int i = 0;i<n;i++) {
            checkBox.put(num[i],1); 
        }
        int result = 1;
        for (int i = 0;i<n;i++) {
            if(checkBox.containsKey(num[i])){
            	int findKey = num[i]+1;
            	while (checkBox.containsKey(findKey)){
            		checkBox.put(num[i],checkBox.get(num[i])+1);
            		checkBox.remove(findKey);
            		findKey++;
            	}
            	findKey = num[i]-1;
            	while (checkBox.containsKey(findKey)){
            		checkBox.put(num[i],checkBox.get(num[i])+1);
            		checkBox.remove(findKey);
            		findKey--;
            	}
            	if (checkBox.get(num[i])>result){
            		result = checkBox.get(num[i]);
            	}
            }
        }
        return result;
    }
}
