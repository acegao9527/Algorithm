package ExampleSolution.P51_P100;

public class P52_search_in_rotated_sorted_array {

	public int search(int[] A, int target) {
        int n = A.length;
        if (n==0){
            return -1;
        }
        if(A[0]==target){
            return 0;
        }
        if(A[n-1]==target){
            return n-1;
        }
        if (A[0]<target){
            for (int i=0;i<n-1;i++){
                if(A[i]==target){
                    return i;
                }
                else if(A[i]>target){
                    return -1;
                }
                if (A[i]>A[i+1]){
                    return -1;
                }
            }
        }
        else {
            for (int i=n-1;i>0;i--){
                if(A[i]==target){
                    return i;
                }
                else if(A[i]<target){
                    return -1;
                }
                if (A[i]<A[i-1]){
                    return -1;
                }
            }
        }
        return -1;
    }
}
