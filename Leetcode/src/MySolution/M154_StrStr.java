package MySolution;

/**
 * Created by wuzhi1234 on 15/8/16.
 */
public class M154_StrStr {
    public int strStr(String haystack,String needle){
        if (needle==null) return 0;
        if (haystack==null) return -1;
        if (needle.length()>haystack.length()) return -1;

        for (int i = 0;  ; i++) {
            for (int j = 0; ; j++) {
                if (j==needle.length()) return i;
                if (i+j==haystack.length()) return -1;
                if (haystack.charAt(i+j)!=needle.charAt(j)) break;
            }
        }
    }

    public static void main(String[] args) {
        M154_StrStr m = new M154_StrStr();
        System.out.println(m.strStr("sfljsflj","lj"));
    }
}
