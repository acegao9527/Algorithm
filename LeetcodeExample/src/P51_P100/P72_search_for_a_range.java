package P51_P100;


public class P72_search_for_a_range {

	public int[] searchRange(int[] A, int target) {
        int []result ={-1,-1};
        if (A.length==0){
            return result;
        }
        int start = 0, end = A.length-1;
        if (start == end){
            if (A[start]== target){
                result[0]=result[1]=0;
            }
            return result;
        }
        while (start <= end&&A[start]<=target&&A[end]>=target){
            int mid = (start+end)/2;
            if (A[mid]>target){
                end = mid-1;
            }
            else if (A[mid]<target){
                start = mid+1;
            }
            else {
                int a = mid-1;
                while (a>=0&&A[a] == target) a--;
                result[0] = a+1;
                a = mid+1;
                while (a<A.length&&A[a] == target) a++;
                result[1] = a-1;
                break;
            }
        }
        return result;
    }
}
