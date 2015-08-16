package ExampleSolution.P101_P150;

import java.util.ArrayList;

public class P120_spiral_matrix {

	public ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int direction = 0;
        int m = matrix.length;
        if (m<=0)
            return result;
        int n = matrix[0].length;
        int i=0,j=0,index = 0;
        int[] line = new int[4];
        line[0] = line[1] = line[2] = line[3] = 0;
        while (index<m*n) {
            result.add(matrix[i][j]);
            switch (direction) {
                case 0:
                    if(j<n-line[1]-1)
                        j++;
                    else {
                        line[0]++;
                        direction = 1;
                        i++;
                    }
                    break;
                case 1:
                    if(i<m-line[2]-1)
                        i++;
                    else {
                        line[1]++;
                        direction = 2;
                        j--;
                    }
                    break;
                case 2:
                    if(j>line[3])
                        j--;
                    else {
                        line[2]++;
                        direction = 3;
                        i--;
                    }
                    break;
                case 3:
                    if(i>line[0])
                        i--;
                    else {
                        line[3]++;
                        direction = 0;
                        j++;
                    }
            }
            index++;
        }
        return result;
    }
}
