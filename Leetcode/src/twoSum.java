/*import java.util.*;
public class twoSum{
	public int[] solution(int[] nums,int target){
		Map<Integer,Integer> map = new HashMap<>();
		for (int i =0;i <nums.length ;i++ ) {
			int x = nums[i];
			if (map.containsKey(target-x)) {
				return new int[] {map.get(target-x)+1,i+1};
			}
			map.put(x,i);
		}
		throw new IllegalArgumentException("no two sum solution");
	}
	public static void main(String[] args) {
		int[] a = {1,3,4,5,6,8,9,5,7,4};
		twoSum b = new twoSum();
		int[] c = b.solution(a,12);
		for (int i :c ) {
			System.out.println(i);	
		}
	}
}*/

import java.util.*;
public class TwoSum {
	public int[] solution(int[] numbers, int target) {
	   Map<Integer, Integer> map = new HashMap<>();

	   for (int i = 0; i < numbers.length; i++) {
	      int x = numbers[i];
	      //将数组中的值作为key，索引作为value
	      //这样key重复的时候，只会取后放入的那一个
	      if (map.containsKey(target - x)) {
	         return new int[] { map.get(target - x) + 1, i + 1 };
	      }
	      map.put(x, i);//放入同一个值的键值对，只会保留第一个
	   }
	   throw new IllegalArgumentException("No two sum solution");
	}
	public static void main(String[] args) {
		int[] a = {1,3,4,5,6,8,9,5,7,4};
		TwoSum b = new TwoSum();
		int[] c = b.solution(a,9);
		for (int i :c ) {
			System.out.println(i);
		}
	}
}