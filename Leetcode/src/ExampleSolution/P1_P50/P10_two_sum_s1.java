package ExampleSolution.P1_P50;
import java.util.Arrays;


public class P10_two_sum_s1 {


    public static int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int []sorted = new int[n];
        System.arraycopy(numbers, 0, sorted, 0, n);
        Arrays.sort(sorted);
        int []result = {-1,-1};
        int start = 0;
        int end = n-1;
        while (sorted[end]>target){
            end--;
        }
        int number1=0,number2=0;
        while (start<end){
            int sum = sorted[start]+sorted[end];
            if (sum==target){
                number1 = sorted[start];
                number2 = sorted[end];
                break;
            }
            if (sum>target){
                end--;
            }
            else{
                start++;
            }
        }
        for (int i = 0;i<n;i++){
            if(numbers[i]==number1&&result[0]==-1){
                result[0]=i+1;
                continue;
            }
            if(numbers[i]==number2&&result[1]==-1){
                result[1]=i+1;
            }
        }
        return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[] = {-3,2,3,4};
		int b = 0;
		
		System.out.print(twoSum(A,b).toString());

	}
}
