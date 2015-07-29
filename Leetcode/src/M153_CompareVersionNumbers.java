/**
 * Created by wuzhi1234 on 15/7/28.
 */
/*Compare two version numbers version1 and version2.
If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.

You may assume that the version strings are non-empty and contain only digits and the . character.
The . character does not represent a decimal point and is used to separate number sequences.
For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.

Here is an example of version numbers ordering:

0.1 < 1.1 < 1.2 < 13.37*/
public class M153_CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        //contains的参数是CharSequence，对于. 无需使用转义字符
        if (version1.contains(".") && version2.contains(".")) {
            String[] v1 = version1.split("\\.");
            String[] v2 = version2.split("\\.");
            int c1 = Integer.signum(Integer.parseInt(v1[0]) - Integer.parseInt(v2[0]));
            int c2 = Integer.signum(Integer.parseInt(v1[1]) - Integer.parseInt(v2[1]));
            switch (c1) {
                case 1:
                    return 1;
                case -1:
                    return -1;
                case 0: {
                    switch (c2) {
                        case 1:
                            return 1;
                        case -1:
                            return -1;
                        case 0:
                            return 0;
                    }
                }
            }
        }

        if (!version1.contains(".") && !version2.contains(".")) {
            if (Integer.parseInt(version2) < Integer.parseInt(version1)) {
                return 1;
            }
            if (Integer.parseInt(version1) < Integer.parseInt(version2)) {
                return -1;
            }
            if (Integer.parseInt(version1) == Integer.parseInt(version2)) {
                return 0;
            }
        }

        if (version1.contains(".") && !version2.contains(".")) {
            String[] v1 = version1.split("\\.");
            if (Integer.parseInt(v1[0]) > Integer.parseInt(version2)) {
                return 1;
            }
            if (Integer.parseInt(v1[0]) < Integer.parseInt(version2)) {
                return -1;
            }
            if (Integer.parseInt(v1[1]) > 0) return 1;
            return 0;
        } else {
            if (!version1.contains(".") && version2.contains(".")) {
                String[] v2 = version2.split("\\.");
                if (Integer.parseInt(version1) > Integer.parseInt(v2[0])) {
                    return 1;
                }
                if (Integer.parseInt(version1) < Integer.parseInt(v2[0])) {
                    return -1;
                }
                if (Integer.parseInt(v2[1]) > 0) return -1;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        M153_CompareVersionNumbers m = new M153_CompareVersionNumbers();
        int a = m.compareVersion("1.0", "1.1");
        System.out.println(a);
    }
}
