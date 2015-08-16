package TestSolution;

import java.util.HashMap;
import java.util.Stack;

/**
 * Created by wuzhi1234 on 15/7/27.
 */
public class T152_ValidParentheses {
    public static boolean isValid(String s) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);

            if (map.containsKey(curr)) {
                stack.push(curr);
            } else if (map.containsValue(curr)) {
                //如果是右括号，那就看栈顶元素作为key值的value是否等于右括号
                if (!stack.empty() && map.get(stack.peek()) == curr) {
                    /*等于就删除栈顶指针*/
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        boolean a = isValid("{}{}{}");
        System.out.println(a);
    }
}
