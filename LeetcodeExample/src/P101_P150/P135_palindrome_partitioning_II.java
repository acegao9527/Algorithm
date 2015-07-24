package P101_P150;

public class P135_palindrome_partitioning_II {

	public static int minCut(String s) {
        int len = s.length();
        if(len<=1)
            return 0;
        int[] minC = new int[len];
        for(int i =0;i<len;i++)
        minC[i] = i;
        boolean[][] isP = new boolean[len][len];
        for(int i = 0;i<len;i++)
            for(int j = 0;j<len;j++)
                isP[i][j] = false;
        for(int j = 0;j<len;j++){
            for(int i = 0;i<=j;i++){
                if((j-i<2||isP[i+1][j-1])&&s.charAt(i)==s.charAt(j)){
                    isP[i][j] = true;
                    if(i>0){
                        minC[j] = Math.min(minC[j],minC[i-1]+1);
                    }
                }
                if(isP[0][j])
                    minC[j] = 0;
            }
        }
        return minC[len-1];
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "cdd";
		minCut(s);
	}
}
