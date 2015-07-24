package P101_P150;

import java.util.Stack;

public class P119_largest_rectangle_in_histogram {

	public int largestRectangleArea(int[] height) {
        Stack<Integer> stk = new Stack<Integer>();
        int index = 0;
        int result = 0;
        while (index<height.length) {
            if (stk.isEmpty()||height[stk.peek()]<=height[index]) {
                stk.push(index);
                index++;
            }
            else {
                int t = stk.pop();
                result = Math.max(result, height[t]*(stk.isEmpty()?index:index-stk.peek()-1));
            }
        }
        while (!stk.isEmpty()) {
            int t = stk.pop();
            result = Math.max(result, height[t]*(stk.isEmpty()?height.length:height.length-stk.peek()-1));
        }
        return result;
    }
}
