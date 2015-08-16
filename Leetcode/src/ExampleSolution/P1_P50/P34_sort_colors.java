package ExampleSolution.P1_P50;

public class P34_sort_colors {

	public static void sortColors(int[] A) {
        int p1 = 0;
        int p2 = A.length-1;
        for (int i = p1;i<=p2;i++){
            if(A[i]==2){
                if(i!=p2){
                    A[i]+=A[p2];
                    A[p2]=A[i]-A[p2];
                    A[i]-=A[p2];
                }
                p2--;
                i--;
            }
            else if(A[i]==0){
                A[i]+=A[p1];
                A[p1]=A[i]-A[p1];
                A[i]-=A[p1];
                p1++;
            }
        }
    }
	public static void main(String[] args){
		int []A={1,2,0};
		sortColors(A);
	}
}
