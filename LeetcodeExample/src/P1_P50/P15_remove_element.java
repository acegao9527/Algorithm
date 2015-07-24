package P1_P50;

public class P15_remove_element {

    public static int removeElement(int[] A, int elem) {
        int n = A.length;
        if (n<=0){
            return 0;
        }
        int start = 0, end =0;
        while (end < n){
            if (A[end] != elem){
                A[start] = A[end];
                start++;
            }
            end++;
        }
        return start;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []A = {4,5};
		int b = 4;
		removeElement(A,b);

	}
}
