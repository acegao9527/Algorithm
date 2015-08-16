package ExampleSolution.P1_P50;

public class P14_climbing_stairs {

    public int climbStairs(int n) {
    	
        if(n<=0){
            return 0;
        }
        if (n<=2){
            return n;
        }
        int result[] = new int[n+1];
        result[0]=0;
        result[1]=1;
        result[2]=2;
        for (int i=3;i<=n;i++){
            result[i] = result[i-1]+result[i-2];
        }
        return result[n];
    }
}
