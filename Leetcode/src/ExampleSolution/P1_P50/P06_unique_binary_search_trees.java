package ExampleSolution.P1_P50;

public class P06_unique_binary_search_trees {

    public int numTrees(int n) {
        if (n <=2){
            return n;
        }
        int result = 2*numTrees(n-1);
        for (int i=2;i<n;i++){
            result += numTrees(i-1)*numTrees(n-i);
        }
        return result;
    }
}
