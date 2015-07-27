/**
 * Created by wuzhi1234 on 15/7/27.
 */
public class M61_LengthOfLastWord {

    public int Solution(String s) {
        String[] a = s.split(" ");
        if (a==null || a.length==0) {
            return 0;
        }
        return a[a.length-1].length();
    }
    public static void main(String[] args) {
        String t = "I'm gao jing bao";
        M61_LengthOfLastWord a =new M61_LengthOfLastWord();
        int j=a.Solution(t);
        System.out.println(j);
    }
}
