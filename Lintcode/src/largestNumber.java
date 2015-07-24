import java.util.*;
public class largestNumber {  
    public String Solution(int[] num) {  
        int n = num.length;  
        if (n < 1) return "";  
          
        //把数组转化为字符串数组  
        String[] strs = new String[n];  
        for (int i = 0; i < n; i++) {  
            strs[i] = String.valueOf(num[i]);  
        }  
          
        //按照数字在结果中的位置排序  
        Arrays.sort(strs, new Cmp());  
          
        //把所有字符串拼接在一起  
        String ans = "";  
        for (int i = n - 1; i >= 0; i--) {  
            ans = ans.concat(strs[i]);  
        }  
          
        //去掉数字开头的0，如输入[0, 0]  
        int i = 0;  
        while (i < n && ans.charAt(i) == '0') {  
            i++;  
        }  
        if (i == n) return "0";  
          
        return ans.substring(i);  
    }  
    public static void main(String[] args) {
        int[] num = {2147483647,2147483647,2147483646,9,1,8};
        largestNumber a = new largestNumber();
        System.out.println(a.Solution(num));
    }
}  
  
//比较方法很简单：如果[a在前b在后]组成的结果大于[b在前a在后]组成的结果，那么a>b。  
class Cmp implements Comparator<String>{  
    @Override  
    public int compare(String a, String b) {  
        String ab = a.concat(b);  
        String ba = b.concat(a); 
        for (int i=0;i<ab.length() ;i++ ) {
            if (ab.charAt(i)<ba.charAt(i)) {
                return -1;
            }
            if (ab.charAt(i)>ba.charAt(i)) {
                return 1;
            }
        }
        return 0;
    }  
}  
