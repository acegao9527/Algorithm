package ExampleSolution.P1_P50;

public class P49_spiral_matrix_II {

	public int[][] generateMatrix(int n) {
        int line[] = new int [4];
        line[0]= line[1]=line[2]=line[3]=0;
        int direction = 0;
        int [][]result = new int [n][n];
        int i=0, j=0,num=1;
        while (num<=n*n){
            result[i][j]=num;
            num++;
            switch (direction){
                case 0:{
                    if(j+line[1]==n-1){
                        direction++;
                        line[0]++;
                        i++;
                    }
                    else{
                        j++;
                    }
                    break;
                }
                case 1:{
                    if(i+line[2]==n-1){
                        direction++;
                        line[1]++;
                        j--;
                    }
                    else{
                        i++;
                    }
                    break;
                }
                case 2:{
                    if(j==line[3]){
                        direction++;
                        line[2]++;
                        i--;
                    }
                    else{
                        j--;
                    }
                    break;
                }
                case 3:{
                    if(i==line[0]){
                        direction=0;
                        line[3]++;
                        j++;
                    }
                    else {
                        i--;
                    }
                }
            }
        }
        return result;
    }
}
