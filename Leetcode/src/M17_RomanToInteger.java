import java.util.HashMap;

/**
 * Created by wuzhi1234 on 15/7/28.
 */
public class M17_RomanToInteger {
    public int romantoint(String s){
        HashMap<Character,Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);

        if (s.length()<1){
            return 0;
        }
        int result =0;
        int sub = map.get(s.charAt(0));
        int lastc = sub;
        for (int i = 1; i <s.length(); i++) {
            int curc = map.get(s.charAt(i));
            if (curc==lastc){
                sub += curc;
            }else if (curc<lastc){
                result += sub;
                sub = curc;
            }else {
                sub = curc-sub;
            }
            lastc=curc;
        }
        result += sub;
        return result;
    }

    public static void main(String[] args) {
        M17_RomanToInteger t = new M17_RomanToInteger();
        int a = t.romantoint("DCXXI");
        System.out.println("result:"+a);
    }
}
