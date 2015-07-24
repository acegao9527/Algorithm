package P1_P50;

public class P36_unique_path {

	public int uniquePaths(int m, int n) {
        if (m==0||n==0){
            return 0;
        }
        int posible[][] = new int[m][n];
        posible[0][0] = 1;
        for (int i = 1;i<m;i++){
            posible[i][0] = 1;
        }
        for (int i = 1;i<n;i++){
            posible[0][i] = 1;
        }
        for (int i = 1;i<m;i++){
            for (int j=1;j<n;j++){
                posible[i][j] = posible[i-1][j] + posible[i][j-1];
            }
        }
        return posible[m-1][n-1];
    }
}
