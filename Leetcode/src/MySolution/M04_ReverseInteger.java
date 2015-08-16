package MySolution;

/**
 * Created by wuzhi1234 on 15/7/27.
 */
public class M04_ReverseInteger {
    public static int reverse(int x){
        if (x==0){
            return 0;
        }
        if (x%10==0){
            return reverse(x/10);
        }
        long tmp=0;
        while (x/10!=0){
            tmp=x%10+tmp*10;
            x=x/10;
        }
        tmp=x%10+tmp*10;
        if (tmp>Integer.MAX_VALUE || tmp<Integer.MIN_VALUE){
            return 0;
        }
        return (int)tmp;
    }

    public static void main(String[] args) {
        int x=reverse(1534236469);
        System.out.println(x);
    }
}
