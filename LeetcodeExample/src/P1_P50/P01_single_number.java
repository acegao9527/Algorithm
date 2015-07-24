package P1_P50;

public class P01_single_number {
    public static int singleNumber(int[] A) {
        int result = 0;
        for (int i = 0;i<A.length;i++){
            // for every bit, use bit manipulation. 0^0^0 = 0, 1^1^1 = 1, 0^0^1 = 1, 1^1^0 = 0.
            // Thus, after the bit manipulation of XOR,
            // the every bit of result is the bit of single number.
            result ^= A[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = {1,2,4,3,5,4,2,1,3};
        int b = singleNumber(a);
        System.out.println(b);
        System.out.println(3^5);
        System.out.println(3^3);
        System.out.println(0^3);
    }

}
