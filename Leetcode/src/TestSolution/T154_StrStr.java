package TestSolution;

/**
 * Created by wuzhi1234 on 15/8/16.
 */
public class T154_StrStr {
    public int strStr(String haystack, String needle) {
        for (int i = 0; ; i++) {
            for (int j = 0; ; j++) {
                if (j == needle.length()) return i;
                if (i + j == haystack.length()) return -1;
                if (needle.charAt(j) != haystack.charAt(i + j)) break;
            } }
    }

    public static void main(String[] args) {
        T154_StrStr m = new T154_StrStr();
        System.out.println(m.strStr("sfkasjdlf","ka"));
    }
}
