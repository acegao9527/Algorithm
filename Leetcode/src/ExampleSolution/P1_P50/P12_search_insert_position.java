package ExampleSolution.P1_P50;

public class P12_search_insert_position {

	public int searchInsert(int[] A, int target) {
        int result = 0;
        for (int i=0;i<A.length;i++){
            if(A[i]>=target){
                result = i;
                return i;
            }
        }
        result = A.length;
        return result;
    }
}
