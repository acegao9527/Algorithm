package P51_P100;

public class P66_jump_game {

	public boolean canJump(int[] A) {
        int n = A.length;
        if (n==0){
            return false;
        }
        boolean[] result = new boolean[n];
        result[0]=true;
        for (int k=1;k<0;k++){
            result[k]= false;
        }
        for(int i = 1;i<n;i++){
            for (int j=0;j<i;j++){
                if (result[j]&&j+A[j]>=i){
                    result[i] = true;
                    break;
                }
            }
        }
        return result[n-1];
    }
}
