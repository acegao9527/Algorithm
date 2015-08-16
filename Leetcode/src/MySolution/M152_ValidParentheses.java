package MySolution;

import java.util.HashMap;
import java.util.Stack;

/**
 * Created by wuzhi1234 on 15/7/27.
 */
public class M152_ValidParentheses {
    public static boolean isValid(String s){
        HashMap<Character,Character> map = new HashMap<>();
        map.put('{','}');
        map.put('[',']');
        map.put('(',')');

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i <s.length() ; i++) {
            char ch = s.charAt(i);

            if (map.keySet().contains(ch)){
                stack.push(ch);
            }
            else if (map.values().contains(ch)){
                if (!map.isEmpty() && map.get(stack.peek())==ch){
                    stack.pop();
                }
            }else {
                return false;
            }
        }
        return stack.isEmpty();
    }
    public static void main(String[] args) {
        boolean a = isValid("{}{}{}[");
        System.out.println(a);
    }

}
