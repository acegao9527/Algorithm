package P51_P100;

public class P95_distinct_subsequences {

	public int numDistinct(String S, String T) {
        int a = S.length();
        int b = T.length();
        if (a <b) {
            return 0;
        }
        int[][] tem = new int [a][b];
        for (int i = 0;i<a;i++)
            for (int j=0;j<b;j++)
                tem[i][j] = 0;
        if (S.charAt(0) == T.charAt(0)) {
            tem [0][0] = 1;
        }
        for (int i = 1;i < a;i++){
            tem [i][0] = tem[i-1][0];
            if (S.charAt(i) == T.charAt(0)){
                tem[i][0] ++;
            }
        }
        for (int j = 1;j<b;j++){
            for (int i = j;i<a;i++){
                if (S.charAt(i) == T.charAt(j)) {
                    tem[i][j] = tem[i-1][j-1]+tem[i-1][j];
                }
                else {
                    tem[i][j] = tem[i-1][j];
                }
            }
        }
        return tem[a-1][b-1];
    }
}
