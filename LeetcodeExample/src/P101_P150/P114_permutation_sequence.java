package P101_P150;

public class P114_permutation_sequence {

	public String getPermutation(int n, int k) {
        int[] numSet = new int [n];
        for (int i=0;i<n;i++){
            numSet[i] = i+1;
        }
        int cur = 1;
        while (cur<k) {
            int exIndex = n-2;
            for (;exIndex>=0;exIndex--){
                if (numSet[exIndex+1] >numSet[exIndex])
                    break;
            }
            for (int i = n-1;i>exIndex;i--){
                if (numSet[i]>numSet[exIndex]) {
                    numSet[exIndex] += numSet[i];
                    numSet[i] = numSet[exIndex]- numSet[i];
                    numSet[exIndex] -= numSet[i];
                    break;
                }
            }
            int start = exIndex+1, end = n-1;
            while (start<end) {
                numSet[start] += numSet[end];
                numSet[end] = numSet[start]- numSet[end];
                numSet[start] -= numSet[end];
                start++;end--;
            }
            cur++;
        }
        String result = "";
        for (int i=0;i<n;i++){
            result += numSet[i];
        }
        return result;
    }
}
