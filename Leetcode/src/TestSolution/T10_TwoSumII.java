package TestSolution;

/**
 * Created by wuzhi1234 on 15/8/16.
 */
public class T10_TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
        // Assume input is already sorted.
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum < target) {
                i++;
            } else if (sum > target) {
                j--; } else {
                return new int[] { i + 1, j + 1 }; }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        int[] a = {1,3,4,5,6,8,9
        T10_TwoSumII t = new T10_TwoSumII();
        int[] b = t.twoSum(a,9);
        for (int i:b){
            System.out.println(i);
        }
    }
}

