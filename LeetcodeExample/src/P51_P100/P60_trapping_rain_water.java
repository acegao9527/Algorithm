package P51_P100;

public class P60_trapping_rain_water {

	public int trap(int[] A) {
        int n = A.length;
        if(n<=1){
            return 0;
        }
        int result = 0;
        int leftmax [] = new int[n];
        int rightmax [] = new int[n];
        leftmax[0] = A[0];
        rightmax[n-1] = A[n-1];
        for(int i=1;i<n;i++){
            leftmax[i] = Math.max(leftmax[i-1],A[i]);
        }
        for(int i=n-2;i>=0;i--){
            rightmax[i] = Math.max(rightmax[i+1],A[i]);
        }
        for(int i=1;i<n-1;i++){
            result+=Math.min(leftmax[i],rightmax[i])-A[i];
        }
        return result;
    }
}
