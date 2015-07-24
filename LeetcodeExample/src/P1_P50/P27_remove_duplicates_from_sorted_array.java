package P1_P50;

public class P27_remove_duplicates_from_sorted_array {

	public static int removeDuplicates(int[] A) {
        if (A.length <2)
            return A.length;
        
        int num = 0;
        for (int i=1;i<A.length;i++){
            if (A[i]!=A[num])
                num++;
                A[num]= A[i];
        }
	    return num+1;
    }
}
