package ExampleSolution.P1_P50;

public class P24_single_number_II {

	public int singleNumber(int[] A) {
        int ones = 0, twice = 0, threes = 0;
        for(int i = 0; i < A.length; ++i) {
            twice |= (ones & A[i]);
            ones ^= A[i];
            threes = ~(ones & twice);
            ones &= threes;
            twice &= threes;
        }
        return ones;
    }
}
