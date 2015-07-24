/**
 * Created by wuzhi1234 on 15/7/24.
 */
public class BubbleSort_Me{
    public static int[] Solution(int[] a){
        for (int i=0;i<a.length-1 ;i++ ) {
            for (int j=0;j<a.length-i-1 ;j++ ) {
                if (a[j]>a[j+1]) {
                    int tmp=a[j];
                    a[j]=a[j+1];
                    a[j+1]=tmp;
                }
            }
        }
        return a;
    }
    public static void main(String[] args) {
        int[] test = {3,5,6,7,2,1};
        int[] result =BubbleSort_Me.Solution(test);
        for (int i=0;i<=result.length-1 ;i++ ) {
            System.out.println(result[i]);
        }
    }
}
