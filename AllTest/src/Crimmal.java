import java.util.Scanner;

/**
 * Created by wuzhi1234 on 15/9/12.
 */
public class Crimmal {
    public int solution(){
        System.out.println("please input1:");
        Scanner scanner1 = new Scanner(System.in);
        int[] a = new int[3];
        for(int i=0;i<3;i++){
            a[i]=scanner1.nextInt();
//            System.out.println(a[i]);
        }
        System.out.println("please input2:");
        Scanner scanner2 = new Scanner(System.in);
        int[] b = new int[a[0]];
        for (int j = 0; j < b.length; j++) {
            b[j]=scanner2.nextInt();
//            System.out.println(b[j]);
        }
        int count=0;
        for (int k = 0; k < b.length - a[2]; k++) {
            int heavy=0;
            for (int l = 0; l < a[2]; l++) {
                heavy += b[k+l];
            }
            if (heavy<=a[1]){
                count++;
            }
        }
        return count;

    }

    public static void main(String[] args) {
        Crimmal c = new Crimmal();
        int a = c.solution();
        System.out.println(a);
    }
}
