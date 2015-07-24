package P51_P100;

public class P98_jump_game_II {

	public int jump(int[] A) {
        int len = A.length;
        int step = 0;
        int startIndex = 0;
        int maxIndex = 0;
        while(maxIndex<len-1){
            int maxStart = maxIndex;
            for (int i = maxIndex;i>=startIndex;i--){
                if(i+A[i]>maxIndex){
                    maxIndex = i+A[i];
                    maxStart = i;
                }
            }
            startIndex = maxStart;
            step++;
        }
        return step;
    }
}
