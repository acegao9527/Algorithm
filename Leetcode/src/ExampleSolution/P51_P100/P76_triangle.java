package ExampleSolution.P51_P100;

import java.util.ArrayList;

public class P76_triangle {

	public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        int len = triangle.size();
        if(len == 0){
            return 0;
        }
        int result[] = new int [len];
        for (int i=0;i<len;i++){
            result[i] = triangle.get(len-1).get(i);
        }
        for(int i = len-2;i>=0;i--){
            for(int j =0;j<=i;j++){
                result[j] = Math.min(result[j],result[j+1])+triangle.get(i).get(j);
            }
        }
        return result[0];
    }
}
