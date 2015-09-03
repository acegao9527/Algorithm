package BinaryTree;

/**
 * Created by wuzhi1234 on 15/9/2.
 */
public class ValuetransTest {
    public static void test(Integer t){
        t=new Integer(1);
        System.out.println("方法内的a为"+t);
    }

    public static void main(String[] args) {
        Integer a = new Integer(0);
        test(a);
        System.out.println("主函数中的a为"+a);
    }
}
