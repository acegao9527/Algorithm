package P101_P150;

public class P110_valid_palindrome {

	public boolean isPalindrome(String s) {
        int start = 0, end = s.length()-1;
        while(start<end){
            char cur1 = s.charAt(start);
            char cur2 = s.charAt(end);

            if (cur1 >='A'&&cur1<='Z') {
                cur1 = (char)(cur1-'A'+'a');//转成小写字母
            }
            else if (!((cur1 >='a'&&cur1<='z')||(cur1>='0'&&cur1<='9'))){
                start++;
                continue;//如果不在比较的区间内，就增加指针跳出循环
            }

            if (cur2 >='A'&&cur2<='Z') {
                cur2 = (char)(cur2-'A'+'a');
            }

            else if (!((cur2 >='a'&&cur2<='z')||(cur2>='0'&&cur2<='9'))){
                end--;
                continue;//如果不在比较范围内，就减小指针跳出循环
            }
            if (cur1!=cur2)
                return false;
            start++;end--;
        }
        return true;
    }
}
