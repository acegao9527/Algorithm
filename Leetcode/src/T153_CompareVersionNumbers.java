/**
 * Created by wuzhi1234 on 15/7/29.
 */
/*比较版本号的新旧

以 . 为界 依次比较每个 . 前的数大小 分出大小就输出
相等就继续 特殊情况是类似 1与1.0的 此时也认为他们相等 代码如下;
*/
public class T153_CompareVersionNumbers {
    public static int compareVersion(String version1, String version2) {
        return compare(version1, 0, version2, 0);
    }
    public static int compare(String version1,int st1, String version2,int st2) {
        int ssa = 1;
        int ssb = 1;
        if (st1 == version1.length() || st1 == version1.length() + 1) {
            ssa = 0;
            if (st2 == version2.length() || st2 == version2.length() + 1) {
                return 0;
            }
        }
        if (st2 == version2.length() || st2 == version2.length() + 1) {
            ssb = 0;
            if (st1 == version1.length() || st1 == version1.length() + 1) {
                return 0;
            }
        }
        int i = st1;
        int a=0;
        if (ssa != 0) {
            String s1 = "";
            for (; i < version1.length(); i++) {
                if (version1.charAt(i) == '.')
                    break;
                else
                    s1 = s1 + version1.charAt(i);
            }
            a = Integer.valueOf(s1);
        }
        int j = st2;
        int b=0;
        if (ssb != 0) {
            String s2 = "";
            for (; j < version2.length(); j++) {
                if (version2.charAt(j) == '.')
                    break;
                else
                    s2 = s2 + version2.charAt(j);
            }
            b = Integer.valueOf(s2);
        }
        if (a > b)
            return 1;
        else {
            if (a < b)
                return -1;
            else {
                if(ssa==0||ssb==0)return 0;
                else return compare(version1, i + 1, version2, j + 1);
            }
        }
    }
}