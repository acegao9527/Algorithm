package ExampleSolution.P1_P50;

public class P23_unique_path_II {

	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid==null){
            return 0;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int [][]result = new int[m][n];
        result [0][0] = (obstacleGrid[0][0]==0?1:0);
        for (int i = 1; i<m;i++){
            if (obstacleGrid[i][0]==0){
                result [i][0] = result [i-1][0];
            }
            else {
                result [i][0] = 0;
            }
        }
        for (int i = 1; i<n;i++){
            if (obstacleGrid[0][i]==0){
                result [0][i] = result [0][i-1];
            }
            else {
                result [0][i] = 0;
            }
        }
        for (int i = 1;i<m;i++){
            for (int j = 1;j<n;j++){
                if (obstacleGrid[i][j]==0){
                    result [i][j] = result [i][j-1]+result [i-1][j];
                }
                else {
                    result [i][j] = 0;
                }
            }
        }
        return result[m-1][n-1];
    }
}
