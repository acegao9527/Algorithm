package MySolution;

/**
 * Created by wuzhi1234 on 15/8/16.
 */
public class M110_ValidPalindrome {
    public boolean isPalindrome(String s){
        int i = 0, j = s.length()-1;
        while (i<j){
            while (i<j && !Character.isLetterOrDigit(s.charAt(i))) i++;
            while (i<j && !Character.isLetterOrDigit(s.charAt(j))) j--;
            if (Character.toLowerCase(s.charAt(i))!=Character.toLowerCase(s.charAt(j)))
            {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "sa12:;31As";
        M110_ValidPalindrome m = new M110_ValidPalindrome();
        boolean a = m.isPalindrome(s);
        System.out.println(a);
    }
}
