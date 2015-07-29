/**
 * Created by wuzhi1234 on 15/7/29.
 */
/*比较版本号的新旧

以 . 为界 依次比较每个 . 前的数大小 分出大小就输出
相等就继续 特殊情况是类似 1与1.0的 此时也认为他们相等 代码如下;
*/

public class T153_CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        if(version1 == null || version2 ==null) return 0;

        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        int n1 = v1.length;
        int n2 = v2.length;

        int i=0;

        while(i<n1 || i<n2) {
            int x1 = i<n1 ? Integer.parseInt(v1[i]) : 0;
            int x2 = i<n2 ? Integer.parseInt(v2[i]) : 0;
            if(x1 > x2) return 1;
            else if(x1 < x2) return -1;
            else ++i;
        }

        return 0;

    }
}