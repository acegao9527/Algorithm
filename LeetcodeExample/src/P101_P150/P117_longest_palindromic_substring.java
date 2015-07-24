package P101_P150;

public class P117_longest_palindromic_substring {

	public String longestPalindrome(String s) {
        int result[] = {0,0};
        for (int i = 0;i<s.length();i++) {
            int[] tempRst = findLongestPalindrome(s,i);
            if (result[1]-result[0]<tempRst[1]-tempRst[0]) {
                result[1] = tempRst[1];
                result[0] = tempRst[0];
            }
        }
        return s.substring(result[0],result[1]+1);
    }
    public int[] findLongestPalindrome(String s,int i) {
        int start = i-1; 
        int end = i+1;
        while (start>=0&&end <s.length()){
            if (s.charAt(start) == s.charAt(end)){
                start --;
                end ++;
            }
            else
                break;
        }
        int[] result = {start+1,end-1};
        if (i<s.length()-1&&s.charAt(i)==s.charAt(i+1)) {
            start = i-1; end = i+2;
            while (start>=0&&end <s.length()){
                if (s.charAt(start) == s.charAt(end)){
                    start --;
                    end ++;
                }
                else
                    break;
            }
        }
        if (result[1]-result[0]<end -start-2) {
            result[0] = start+1;
            result[1] = end-1;
        }
        return result;
    }
}
