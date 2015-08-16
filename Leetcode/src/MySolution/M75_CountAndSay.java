package MySolution;

/**
 * Created by wuzhi1234 on 15/7/28.
 */
/*The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth sequence.

Note: The sequence of integers will be represented as a string.
*/
public class M75_CountAndSay {
    public String oneString(String s){
        char tmp = s.charAt(0);
        int num = 1;
        StringBuilder newString = new StringBuilder("");
        for (int i = 1; i < s.length(); i++) {
            if (tmp==s.charAt(i)){
                num++;
                continue;
            }
            newString.append(Integer.toString(num)).append(tmp);
            num = 1;
            tmp = s.charAt(i);
        }
        newString.append(Integer.toString(num)).append(tmp);
        return newString.toString();
    }
    public String CountAndSay(int n){
        String result = "1";
        int i = 1;
        while (i < n){
            result = oneString(result);
            i++;
        }
        return result;
    }

    public static void main(String[] args) {
        M75_CountAndSay m = new M75_CountAndSay();
        String a = m.CountAndSay(5);
        System.out.println(a);
    }
}
