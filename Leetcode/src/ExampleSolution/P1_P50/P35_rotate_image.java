package ExampleSolution.P1_P50;

public class P35_rotate_image {

	public void rotate(int[][] matrix) {
        int l = matrix.length-1;
        if (l<=0){
            return;
        }
        for (int i = 0;i<=l/2;i++){
            for (int j = 0;j<(l+1)/2;j++){
                int i1 = j;
                int j1 = l-i;
                int i2 = l-i;
                int j2 = l-j;
                int i3 = l-j;
                int j3 = i;
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i3][j3];
                matrix[i3][j3] = matrix[i2][j2];
                matrix[i2][j2] = matrix[i1][j1];
                matrix[i1][j1] = temp;
            }
        }
    }
}
