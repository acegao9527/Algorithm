package ExampleSolution.P51_P100;

public class P90_next_permutation {

	public void nextPermutation(int[] num) {
        int len = num.length;
        if (len <=1){
            return;
        }
        int firstAscend = -1;
        for (int i = len-1;i>0;i--) {
            if (num[i-1]<num[i]){
                firstAscend = i-1;
                break;
            }
        }
        int start = 0;
        int end = len-1;
        if(firstAscend>=0){
            int changeIndex = firstAscend+1;
            for (int i = len-1;i>0;i--) {
                if (num[i]>num[firstAscend]){
                    changeIndex=i;
                    break;
                }
            }
            num[firstAscend] += num[changeIndex];
            num[changeIndex] = num[firstAscend]-num[changeIndex];
            num[firstAscend] -= num[changeIndex];
            start = firstAscend+1;
        }
        while (start<end){
            num[start] += num[end];
            num[end] = num[start]-num[end];
            num[start] -= num[end];
            start++; end--;
        }
    }
}
