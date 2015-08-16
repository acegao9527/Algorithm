package ExampleSolution.P51_P100;

public class P53_search_in_rotated_sorted_array_II {

	public boolean search(int[] A, int target) {
        int n = A.length;
        if (n==0){
            return false;
        }
        if(A[0]==target){
            return true;
        }
        if(A[n-1]==target){
            return true;
        }
        if (A[0]<target){
            for (int i=0;i<n-1;i++){
                if(A[i]==target){
                    return true;
                }
                else if(A[i]>target){
                    return false;
                }
                if (A[i]>A[i+1]){
                    return false;
                }
            }
        }
        else {
            for (int i=n-1;i>0;i--){
                if(A[i]==target){
                    return true;
                }
                else if(A[i]<target){
                    return false;
                }
                if (A[i]<A[i-1]){
                    return false;
                }
            }
        }
        return false;
    }
}
