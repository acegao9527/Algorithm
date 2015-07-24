package P101_P150;

public class P107_first_missing_positive {

	public int firstMissingPositive(int[] A) {
        int len = A.length;
        for (int i =0;i<len;i++){
            while (A[i]!=i+1&&A[i]<=len&&A[i]>0&&A[i]!=A[A[i]-1]){
                int temp = A[A[i]-1];
                A[A[i]-1] = A[i];
                A[i] = temp;
            }
        }
        for (int i =0;i<len;i++) {
            if(A[i]!=i+1){
                return i+1;
            }
        }
        return len+1;
    }
}
