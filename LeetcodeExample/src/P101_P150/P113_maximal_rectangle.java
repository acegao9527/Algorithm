package P101_P150;

import java.util.Stack;

public class P113_maximal_rectangle {

	public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        if (m == 0){
            return 0;
        }
        int n = matrix[0].length;
        int[][] height = new int[m][n+1];
        for (int j = 0;j<n+1;j++) {
            for (int i = 0;i<m;i++) {
                height[i][j] = 0;
            }
        }
        for (int j = 0;j<n;j++) {
            for (int i = 0;i<m;i++) {
                if (matrix[i][j]=='1'){
                    height[i][j] = (i>0?(height[i-1][j]+1):1);
                }
            }
        }
        int result = 0;
        for (int i = 0;i<m;i++) {
            Stack<Integer> stk = new Stack<Integer>();
            int j = 0;
            while (j<n+1){
                if (stk.isEmpty()||(height[i][stk.peek()] <= height[i][j])){
                    stk.push(j);
                    j++;
                }
                else {
                    int index = stk.pop();
                    result = Math.max(result,height[i][index]*(stk.isEmpty()?j:j-stk.peek()-1));
                }
            }
        }
        return result;
    }
}
