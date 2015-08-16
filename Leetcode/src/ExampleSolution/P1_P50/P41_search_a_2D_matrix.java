package ExampleSolution.P1_P50;

public class P41_search_a_2D_matrix {

	public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0){
            return false;
        }
        int n = matrix[0].length;
        for (int i=m-1;i>=0;i--){
            if(matrix[i][0]<=target){
                for (int j=0;j<n;j++){
                    if(matrix[i][j]==target){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
