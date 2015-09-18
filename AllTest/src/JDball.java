import java.util.Scanner;

/**
 * Created by wuzhi1234 on 15/9/18.
 */
public class JDball {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int sum =0 ;
        String[] str = in.nextLine().split(" ");
        int[] a = new int[str.length];
        for (int i = 0; i < str.length; i++) {
            a[i]=Integer.parseInt(str[i]);
            sum=sum+a[i];
        }
        sum = sum *3;
        System.out.println(sum);
    }
}
