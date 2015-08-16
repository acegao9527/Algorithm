package ExampleSolution.P51_P100;

public class P93_edit_distance {

	public int minDistance(String word1, String word2) {
        int a = word1.length();
        int b = word2.length();
        int [][]tem = new int[a+1][b+1];
        for (int i=0;i<=a;i++){
            tem[i][0] = i;
        }
        for (int i=1;i<=b;i++){
            tem[0][i] = i;
        }
        for (int i = 1;i<=Math.min(a,b);i++) {
            for (int j =i;j<=a;j++) {
                if (word1.charAt(j-1) == word2.charAt(i-1)){
                    tem[j][i] = tem[j-1][i-1];
                }
                else {
                    tem[j][i] = Math.min(Math.min(tem[j-1][i],tem[j][i-1]), tem[j-1][i-1])+1;
                }
            }
            for (int j = i+1;j<=b;j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)){
                    tem[i][j] = tem[i-1][j-1];
                }
                else {
                    tem[i][j] = Math.min(Math.min(tem[i-1][j],tem[i][j-1]), tem[i-1][j-1])+1;
                }
            }
        }
        return tem[a][b];
    }
}
