package ExampleSolution.P1_P50;

public class P42_set_matrix_zeroes {

    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        if (m==0){
            return;
        }
        int n = matrix[0].length;
        boolean firstRowHasZero = false;
        boolean firstColumnHasZero = false;
        for (int i=0;i<n;i++){
            if (matrix[0][i] == 0){
                firstRowHasZero = true;
            }
        }
        for (int i=0;i<m;i++){
            if (matrix[i][0] == 0){
                firstColumnHasZero = true;
            }
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if (matrix[i][j]==0){
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        for (int i=1;i<n;i++){
            if (matrix[0][i] == 0){
                for (int j=1;j<m;j++){
                    matrix[j][i] = 0;
                }
            }
        }
        for (int i=1;i<m;i++){
            if (matrix[i][0] == 0){
                for (int j=1;j<n;j++){
                    matrix[i][j] = 0;
                }
            }
        }
        if (firstRowHasZero){
            for (int i=0;i<n;i++){
                matrix[0][i] = 0;
            }
        }
        if (firstColumnHasZero){
            for (int i=0;i<m;i++){
                matrix[i][0] = 0;
            }
        }
    }
}
