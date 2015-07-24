package P1_P50;

public class P26_merge_sorted_array {

	public void merge(int A[], int m, int B[], int n) {
        if (m<=0&&n<=0){
            return;
        }
        int index = m+n-1;
        while(m!=0&&n!=0){
            if(A[m-1]>B[n-1]){
                A[index]=A[m-1];
                m--;
            }
            else {
                A[index]=B[n-1];
                n--;
            }
            index--;
        }
        if (n!=0){
            for(int i=n-1;i>=0;i--){
                A[i]=B[i];
            }
        }
    }
}
