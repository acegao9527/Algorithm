package TestSolution;

/**
 * Created by wuzhi1234 on 15/8/16.
 */
public class T155_ReverseWordsInString {
    public String reverseWords(String s) {
        StringBuilder reversed = new StringBuilder();
        int j = s.length();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                //如果i位置为空格，就将j指向i位置
                j = i;
            }
            //直到队尾的空格全部跳过去了，开始正文
            else {
                //当前位置为首位或者当前位置不为空但它前一位为空
                if (i == 0 || s.charAt(i - 1) == ' ') {
                    //用来存储结果的String不为空的话，需要加空格再加结果
                    if (reversed.length() != 0) {
                        reversed.append(' ');
                    }
                    //用来存储结果的String为空的话，直接添加那段单词即可
                    reversed.append(s.substring(i, j));
                    /*Examples:
                    "hamburger".substring(4, 8) returns "urge"
                    "smiles".substring(1, 5) returns "mile"*/
                }
            }
        }
        return reversed.toString();
    }

    public static void main(String[] args) {
        T155_ReverseWordsInString t = new T155_ReverseWordsInString();
        System.out.println(t.reverseWords("    the sky is blue"));
    }
}
