package Sorts;

/**
 * Created by wuzhi1234 on 15/8/24.
 */
public class Bubble {
    public int[] sort(int[] a){
        int tmp = 0;
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j]>a[j+1]){
                   tmp = a[j+1];
                   a[j+1] = a[j];
                   a[j] = tmp;
                }
            }
        }
        return a;
    }

    public static void main(String[] args) {
        Bubble b = new Bubble();
        int[] a = {2,4,5,3};
        int[] c = b.sort(a);
        for (int i = 0; i < c.length; i++) {
            System.out.print(c[i]);
        }
    }
}
