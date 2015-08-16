package ExampleSolution.P1_P50;
import java.util.HashMap;


public class P10_two_sum_s2 {

	public static int[] twoSum(int[] numbers, int target) {
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		int n =numbers.length;
		int [] result = {-1,-1};
		for (int i=0;i<n;i++){
			if (map.containsKey(target-numbers[i])){
				result[0] = map.get(target-numbers[i])+1;
				result[1] = i;
				break;
			}
			else{
				map.put(numbers[i], i);
			}
		}
		return result;
    }
}
