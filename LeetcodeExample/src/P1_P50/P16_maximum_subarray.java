package P1_P50;

public class P16_maximum_subarray {

	public int maxSubArray(int[] A) {
        int n = A.length;
        int []result = new int[n];
        result [0] = A[0];
        for (int i =1;i<n;i++){
            if(result[i-1]+A[i]<A[i]){
                result [i] = A[i];
            }
            else {
                result [i] = result[i-1]+A[i];
            }
        }
        int max = result[0];
        for (int i =1;i<n;i++){
            if(result[i]>max){
                max = result[i];
            }
        }
        return max;
    }
	
}
