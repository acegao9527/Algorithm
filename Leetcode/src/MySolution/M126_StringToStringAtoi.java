package MySolution;/*问题：
把一个字符串转成一个整数。
思路：
其实，这道题考的不是怎么去把一个数转成一个整数，而是考你是否能够把所有的情况都考虑完全，我们应该考虑的因素如下：
1. 这个字符串是否是空的。
2. 这个字符串是否有非法字符（非0-9之间的字符）。
3.这个数是正数或者是负数的情况（第一个字符是否为+，-）。
4. 是否存在溢出的情况（这个比较难考虑到）。
*/

public class M126_StringToStringAtoi {
    public static int myAtoi(String str) {
        int index = 0;
        int sign = 1;
        char ch;
        int digit;
        int total = 0;
        //1. Empty string
        if(str.length() == 0) return 0;
        //2. Remove Spaces
        while(str.charAt(index) == ' ' && index < str.length())
        {
            index ++;
        }
        //3. Handle signs
        if(str.charAt(index) == '+' || str.charAt(index) == '-')
        {
            if(str.charAt(index) == '+')
                sign = 1;
            else
                sign = -1;
            index ++;
        }

        //4. Convert number and avoid overflow
        while(index < str.length())
        {
            ch = str.charAt(index);
            if(ch < '0' || ch > '9') break;
            digit = ch - '0';
            //check if total will be overflow after 10 times and add digit
            if(Integer.MAX_VALUE/10 < total || Integer.MAX_VALUE/10 == total && Integer.MAX_VALUE %10 < digit)
                return sign == 1?Integer.MAX_VALUE:Integer.MIN_VALUE;

            total = 10*total + digit;
            index ++;
        }
        return total * sign;
    }
    public static void main(String[] args) {
        String a="-2147483647";
        int b = M126_StringToStringAtoi.myAtoi(a);
        System.out.println(b);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
    }
}