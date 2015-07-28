/**
 * Created by wuzhi1234 on 15/7/28.
 */
/*Write a function to find the longest common prefix string amongst an array of strings.*/
/**/
public class M71_LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs){
        if (strs.length<1){return "";}
        if (strs.length==1){return strs[0];}
        String tmp = strs[0];
        for (int i = 1; i < strs.length; i++) {
            tmp = compareTwoSting(tmp,strs[i]);
        }
        return tmp;
    }
    public String compareTwoSting(String s1,String s2){
        if (s1.length()==0 || s2.length()==0) return "";
        int length = Math.min(s1.length(), s2.length());
        StringBuffer str = new StringBuffer();
        for (int i = 0; i <length ; i++) {
            if (s1.charAt(i)==s2.charAt(i)){
                str.append(s1.charAt(i));
            }
            else break;
        }
        return str.toString();
    }

    public static void main(String[] args) {
        M71_LongestCommonPrefix m = new M71_LongestCommonPrefix();
//        String[] strs = {"gao","gaosdf","gaodfhsf"};
        String[] strs = {};
        String result = m.longestCommonPrefix(strs);
        System.out.println(result);
    }
}
