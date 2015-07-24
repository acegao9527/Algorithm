/*Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

For example, 
Given s = "Hello World",
return 5.*/

// 需要考虑字符串是null或者全部空格的情况，可以在分割之前做判断

public class LengthOfLastWord {
    public int Solution(String s) {
        String[] a = s.split(" ");
        if (a==null || a.length==0) {
         	return 0;
         } 
        return a[a.length-1].length();
    }
    public static void main(String[] args) {
    	String t = "I'm gao jing bao";
    	LengthOfLastWord a =new LengthOfLastWord();
    	int j=a.Solution(t);
    	System.out.println(j);
    }
}