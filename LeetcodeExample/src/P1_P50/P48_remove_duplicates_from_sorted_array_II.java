package P1_P50;

public class P48_remove_duplicates_from_sorted_array_II {

	public int removeDuplicates(int[] A) {
        int n = A.length;
        if(n<=2){
            return n;
        }
        int repeat = 1;
        int p1 = 0,p2 = 1;
        for (;p2<n;p2++){
            if(A[p2-1]==A[p2]){
                if (repeat <2){
                    repeat ++;
                    A[p1+1] = A[p2];
                    p1++;
                }
                else {
                    continue;
                }
            }
            else {
                repeat = 1;
                A[p1+1] = A[p2];
                p1++;
            }
        }
        return p1+1;
    }
}
