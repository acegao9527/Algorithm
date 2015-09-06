/**
 * Created by wuzhi1234 on 15/9/6.
 */
public class InsertSort_Me {
    public static int[] sort(int[] a){
        int length=a.length;
        int i;
        int j;
        int key;
        for (i = 1; i < length; i++) {
            key=a[i];
            j=i-1;
            while (j>=0 && a[j]>key){
                a[j+1]=a[j];
                j--;
            }
            a[j+1]=key;
        }
        return a;
    }

    public static void main(String[] args) {
        int test[]={3,5,8,4,0,3,7,8};
        InsertSort_Me.sort(test);
        for(int i=0;i<test.length;i++){
            System.out.println(test[i]);
        }
    }
}
